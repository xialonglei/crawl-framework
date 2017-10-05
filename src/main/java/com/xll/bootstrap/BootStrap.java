package com.xll.bootstrap;

import com.xll.model.DubboSchema;
import com.xll.page.PageCrawl;
import com.xll.page.model.FieldParse;
import com.xll.page.model.PageCrawlRule;
import com.xll.page.model.PageInfo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lonely.xia on 2017/10/1.
 */
public class BootStrap {


    public static void main(String[] args) {

        PageCrawlRule pageCrawlRule = assemblyCrawlInfo();

        new PageCrawl(pageCrawlRule).start();

    }

    private static PageCrawlRule assemblyCrawlInfo() {

        PageCrawlRule<DubboSchema> lastChild = new PageCrawlRule<>();
        Map<String , FieldParse> fieldParseMap = new HashMap<>();

        FieldParse fieldParse = new FieldParse();
        fieldParse.setFieldName("attri");
        FieldParse.Rule secondRule  = new FieldParse.Rule("td:eq(0)" , "TEXT" , null);
        FieldParse.Rule firstRule
                = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("attri" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("urlPara");
        secondRule  = new FieldParse.Rule("td:eq(1)" , "TEXT" , null);
        firstRule = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("urlPara" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("attriType");
        secondRule  = new FieldParse.Rule("td:eq(2)" , "TEXT" , null);
        firstRule = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("attriType" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("isWrite");
        secondRule  = new FieldParse.Rule("td:eq(3)" , "TEXT" , null);
        firstRule = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("isWrite" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("defaultValue");
        secondRule  = new FieldParse.Rule("td:eq(4)" , "TEXT" , null);
        firstRule = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("defaultValue" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("func");
        secondRule  = new FieldParse.Rule("td:eq(5)" , "TEXT" , null);
        firstRule = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("func" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("descript");
        secondRule  = new FieldParse.Rule("td:eq(6)" , "TEXT" , null);
        firstRule = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("descript" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("compatibleAbility");
        secondRule  = new FieldParse.Rule("td:eq(7)" , "TEXT" , null);
        firstRule = new FieldParse.Rule("tbody tr" , "HTML" , secondRule);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("compatibleAbility" , fieldParse);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPreUrl("https://dubbo.gitbooks.io/dubbo-user-book/content/references/xml/");
        pageInfo.setRequestMethod("GET");
        lastChild.setFieldParseMap(fieldParseMap);
        lastChild.setCrawlPageName("Dubbo API");
        lastChild.setUseWebClient(false);
        lastChild.setPageInfo(pageInfo);
        lastChild.setPageBO(new DubboSchema());



        PageCrawlRule<DubboSchema> root = new PageCrawlRule<>();
        fieldParseMap = new HashMap<>();

        fieldParse = new FieldParse();
        fieldParse.setFieldName("url");;
        firstRule = new FieldParse.Rule("li[data-path=introduction.html] > ul > li > a[href]"
                , "TEXT" , null);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("url" , fieldParse);

        fieldParse = new FieldParse();
        fieldParse.setFieldName("title");;
        firstRule = new FieldParse.Rule("li[data-path=introduction.html] > ul > li > a[href]"
                , "TEXT" , null);
        fieldParse.setRule(firstRule);
        fieldParseMap.put("title" , fieldParse);



        pageInfo = new PageInfo();
        pageInfo.setRequestMethod("GET");
        pageInfo.setUrl("https://dubbo.gitbooks.io/dubbo-user-book/content/references/xml/introduction.html");

        root.setUseWebClient(false);
        root.setCrawlPageName("Dubbo API First Parent");
        root.setFieldParseMap(fieldParseMap);
        root.setPageInfo(pageInfo);
        root.setChildPageCrawlRule(lastChild);
        root.setPageBO(new DubboSchema());

        return root;
    }

}
