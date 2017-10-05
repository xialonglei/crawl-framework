package com.xll.page;

import com.xll.page.model.PageCrawlRule;

/**
 * Created by lonely.xia on 2017/10/1.
 */
public class PageCrawl {

    private PageCrawlRule pageCrawlRule;

    public PageCrawl(PageCrawlRule pageCrawlRule) {
        this.pageCrawlRule = pageCrawlRule;
    }


    public void start() {
        enterCrawl();
    }

    private void enterCrawl() {

        PageCrawlThread pageCrawlThread =  new PageCrawlThread(pageCrawlRule);
        Thread t = new Thread(pageCrawlThread);
        t.start();

    }
}
