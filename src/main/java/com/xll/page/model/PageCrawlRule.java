package com.xll.page.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lonely.xia on 2017/10/1.
 */
public class PageCrawlRule<T> {

    /** 抓取的网站名 */
    private String crawlPageName;

    /** 抓取的对象 */
    private T pageBO;

    /** 子类抓取规则 */
    private PageCrawlRule childPageCrawlRule;

    private PageInfo pageInfo;

    /** 是否利用模拟浏览器获取源码 */
    private boolean isUseWebClient;

    private Map<String , FieldParse> fieldParseMap = new HashMap<>();

    public T getPageBO() {
        return pageBO;
    }

    public void setPageBO(T pageBO) {
        this.pageBO = pageBO;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getCrawlPageName() {
        return crawlPageName;
    }

    public void setCrawlPageName(String crawlPageName) {
        this.crawlPageName = crawlPageName;
    }

    public PageCrawlRule getChildPageCrawlRule() {
        return childPageCrawlRule;
    }

    public void setChildPageCrawlRule(PageCrawlRule childPageCrawlRule) {
        this.childPageCrawlRule = childPageCrawlRule;
    }

    public Map<String, FieldParse> getFieldParseMap() {
        return fieldParseMap;
    }

    public boolean isUseWebClient() {
        return isUseWebClient;
    }

    public void setUseWebClient(boolean useWebClient) {
        isUseWebClient = useWebClient;
    }

    public void setFieldParseMap(Map<String, FieldParse> fieldParseMap) {
        this.fieldParseMap = fieldParseMap;
    }

}
