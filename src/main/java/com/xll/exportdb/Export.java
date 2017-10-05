package com.xll.exportdb;

import com.xll.page.model.PageCrawlRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lonely.xia on 2017/10/3.
 */
public interface Export<T> {

    void writeDataToDB(List<T> datas);

    void assemblyStoreDatas(PageCrawlRule pageCrawlRule , Map<String , ArrayList<String>> content);
}
