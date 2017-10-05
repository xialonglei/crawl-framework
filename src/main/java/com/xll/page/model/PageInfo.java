package com.xll.page.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/1.
 */
public class PageInfo {

    private String preUrl;
    private String url;
    private String pageSource;
    private String requestMethod;
    private PageInfo parentPageInfo;
    private HashMap<String , String> requestHeaders = new HashMap<>(16);
    private List<RequestParamBean> requestParameters = new ArrayList<>();


    public PageInfo() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageSource() {
        return pageSource;
    }

    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public HashMap<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(HashMap<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public List<RequestParamBean> getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(List<RequestParamBean> requestParameters) {
        this.requestParameters = requestParameters;
    }

    public PageInfo getParentPageInfo() {
        return parentPageInfo;
    }

    public void setParentPageInfo(PageInfo parentPageInfo) {
        this.parentPageInfo = parentPageInfo;
    }

    public String getPreUrl() {
        return preUrl;
    }

    public void setPreUrl(String preUrl) {
        this.preUrl = preUrl;
    }
}
