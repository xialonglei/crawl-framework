package com.xll.page;

import com.xll.importdb.DubboSchemaImport;
import com.xll.page.model.FieldParse;
import com.xll.page.model.PageCrawlRule;
import com.xll.page.model.PageInfo;
import com.xll.page.model.RequestParamBean;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by lonely.xia on 2017/10/1.
 */
public class PageCrawlThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageCrawlThread.class);

    private PageCrawlRule pageCrawlRule;

    public PageCrawlThread(PageCrawlRule pageCrawlRule) {
        this.pageCrawlRule = pageCrawlRule;
    }

    @Override
    public void run() {
        doCrawl(pageCrawlRule);
    }

    private void doCrawl(PageCrawlRule pageCrawlRule) {

        getPageSourceEnter(pageCrawlRule);
    }

    private void getPageSourceEnter(PageCrawlRule pageCrawlRule) {
        // 进行参数校验，校验失败直接返回
        if (!checkArguments(pageCrawlRule)) {
            return;
        }

        LOGGER.info("开始执行网站[{},{}]的抓取......" , pageCrawlRule.getCrawlPageName()
                , pageCrawlRule.getPageInfo().getUrl());

        PageInfo pageInfo = pageCrawlRule.getPageInfo();

        String pageSource = null;

        if (pageCrawlRule.isUseWebClient()) {
            MyWebClient webClient = null;
            try {
                webClient = new MyWebClient();
                pageSource = webClient.visitUrl(pageCrawlRule.getPageInfo().getUrl());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (pageInfo.getRequestMethod().toUpperCase() == "POST") {
            pageSource = crawlByPostRequest(pageInfo);
        } else {
            pageSource = crawlByGetRequest(pageInfo);
        }

        // 实体化HTML，有的网页获取的数据为：&#26469;&#30005;
        pageSource = StringEscapeUtils
                .unescapeHtml4(pageSource);

        parseSource(pageSource , pageCrawlRule);

        LOGGER.info("网站[{},{}]的抓取完毕......" , pageCrawlRule.getCrawlPageName()
                , pageCrawlRule.getPageInfo().getUrl());
    }

    private boolean checkArguments(PageCrawlRule pageCrawlRule) {

        if (pageCrawlRule == null) {
            LOGGER.error("......没有为网站配置抓取规则......");
            return false;
        }

        if (pageCrawlRule.getCrawlPageName() == null) {
            LOGGER.error("......没有为网站设置网站名......");
            return false;
        }

        if (pageCrawlRule.getPageBO() == null) {
            LOGGER.error("......没有为网站[{}]配置储存对象......" , pageCrawlRule.getCrawlPageName());
            return false;
        }

        if (pageCrawlRule.getPageInfo() == null) {
            LOGGER.error("......没有为网站[{}]配置抓取的网页信息......", pageCrawlRule.getCrawlPageName());
            return false;
        }

        if (pageCrawlRule.getPageInfo().getUrl() == null) {
            LOGGER.error("......没有为网站[{}]配置URL......", pageCrawlRule.getCrawlPageName());
            return false;
        }

        if (pageCrawlRule.getPageInfo().getRequestMethod() == null) {
            LOGGER.error("......没有为网站[{}]配置请求方式......", pageCrawlRule.getCrawlPageName());
            return false;
        }

        if (pageCrawlRule.getFieldParseMap().isEmpty()) {
            LOGGER.error("......没有为网站[{}]配置字段抓取规则......", pageCrawlRule.getCrawlPageName());
            return false;
        }

        return true;

    }

    private String crawlByGetRequest(PageInfo pageInfo) {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(pageInfo.getUrl());

        setRequestHeaders(pageInfo , httpGet);

        return doGetPageSource(httpGet , closeableHttpClient);
    }

    private String crawlByPostRequest(PageInfo pageInfo) {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(pageInfo.getUrl());

        setRequestHeaders(pageInfo , httpPost);

        setRequestParameters(pageInfo , httpPost);

        return doGetPageSource(httpPost , closeableHttpClient);

    }

    private void setRequestHeaders(PageInfo pageInfo , HttpRequestBase requestBase) {

        HashMap<String , String> hashMap = pageInfo.getRequestHeaders();

        if (!hashMap.isEmpty()) {
            for (Map.Entry<String , String> entry : hashMap.entrySet()) {
                requestBase.setHeader(entry.getKey() , entry.getValue());
            }
        }
    }

    private void setRequestParameters(PageInfo pageInfo, HttpPost httpPost) {

        List<RequestParamBean> requestParamBeans = pageInfo.getRequestParameters();

        if (requestParamBeans != null && requestParamBeans.size() > 0) {
            List<NameValuePair> params = new ArrayList<>();

            for (RequestParamBean requestParamBean : requestParamBeans) {
                params.add(new BasicNameValuePair(requestParamBean.getParamName()
                        , (String) requestParamBean.getParamValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        }
    }

    private String doGetPageSource(HttpRequestBase requestBase , CloseableHttpClient closeableHttpClient) {

        CloseableHttpResponse response = null;
        String source = null;

        try {
            response = closeableHttpClient.execute(requestBase);
            source = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (closeableHttpClient != null) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return source;

    }

    /**
     * 根据规则抽取网页内容
     *
     * @param pageSource 网页源码
*    * @param fieldParseList 抽取网页源码中的内容规则
     *
     */
    private void parseSource(String pageSource , PageCrawlRule pageCrawlRule) {

        Map<String , FieldParse> fieldParseMap = pageCrawlRule.getFieldParseMap();
        Map<String , ArrayList<String>> content = new HashMap();

        // 解析网页，获取网页字段相应的值
        for (Map.Entry<String , FieldParse> entry : fieldParseMap.entrySet()) {
            FieldParse fieldParse = entry.getValue();
            getParseResult(fieldParse.getRule() , pageSource , pageCrawlRule , content
                    , fieldParse.getFieldName());
        }

        PageCrawlRule childPageCrawlRule = pageCrawlRule.getChildPageCrawlRule();

        if (childPageCrawlRule != null) {
            // 先拿到所有的key值
            List<String> keys = new ArrayList<>();
            for (Map.Entry<String , ArrayList<String>> entry : content.entrySet()) {
                keys.add(entry.getKey());
            }

            for (int i = 0 ; i < content.get(keys.get(0)).size() ; i++) {
                Class clazz = childPageCrawlRule.getPageBO().getClass();
                for (String key : keys) {
                    if ("url".equals(key)) {
                        childPageCrawlRule.getPageInfo().setUrl(content.get(key).get(i));
                    } else {
                        Field field = null;
                        Method method = null;
                        try {
                            field = clazz.getDeclaredField(key);
                            method = clazz
                                    .getDeclaredMethod("set" + key.substring(0,1).toUpperCase()
                                            + key.substring(1) , field.getType());
                            method.invoke(childPageCrawlRule.getPageBO() , content.get(key).get(i));
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage());
                            return;
                        }
                    }
                }
                getPageSourceEnter(childPageCrawlRule);
            }
            return;

        }

        //开始执行入库
        DubboSchemaImport dubboSchemaExport = new DubboSchemaImport();
        dubboSchemaExport.assemblyStoreDatas(pageCrawlRule , content);
    }

    private void getParseResult(FieldParse.Rule rule , String pageSource , PageCrawlRule pageCrawlRule
            , Map content , String fieldName) {

        Document document = Jsoup.parse(pageSource);

        doGetParseResult(document, null, rule, pageCrawlRule, content , fieldName);


    }

    private void doGetParseResult(Document document , Element element , FieldParse.Rule rule
            , PageCrawlRule pageCrawlRule , Map content , String fieldName) {

        Elements eles = null;

        if (element == null) {

            eles = document.select(rule.getParseRule());

        } else {

            eles = element.select(rule.getParseRule());

        }

        PageCrawlRule childPageCrawlRule = pageCrawlRule.getChildPageCrawlRule();
        if (rule.getChildRule() != null) {
            for (Element ele : eles) {
                doGetParseResult(document, ele, rule.getChildRule(), pageCrawlRule , content , fieldName);
            }
        } else {
            for (Element ele : eles) {

                String fieldValue = ele.text();

                if ("url".equals(fieldName)) {
                    fieldValue = ele.select("a").attr("href");
                    String preUrl = childPageCrawlRule.getPageInfo().getPreUrl();
                    fieldValue = (preUrl != null ? preUrl : "") + fieldValue;
                }

                ArrayList<String> fieldValues = (ArrayList<String>) content.get(fieldName);
                if (fieldValues == null) {
                    fieldValues = new ArrayList<>();
                    content.put(fieldName , fieldValues);
                }
                fieldValues.add(fieldValue);

            }
        }
    }

}
