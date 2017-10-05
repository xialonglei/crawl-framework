package com.xll.model;

import java.util.Date;

public class DubboSchema {
    private Long id;

    private String title;

    private String urlPara;

    private String attri;

    private String attriType;

    private Boolean isWrite;

    private String defaultValue;

    private String func;

    private String descript;

    private String compatibleAbility;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrlPara() {
        return urlPara;
    }

    public void setUrlPara(String urlPara) {
        this.urlPara = urlPara == null ? null : urlPara.trim();
    }

    public String getAttri() {
        return attri;
    }

    public void setAttri(String attri) {
        this.attri = attri == null ? null : attri.trim();
    }

    public String getAttriType() {
        return attriType;
    }

    public void setAttriType(String attriType) {
        this.attriType = attriType == null ? null : attriType.trim();
    }

    public Boolean getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(Boolean isWrite) {
        this.isWrite = isWrite;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func == null ? null : func.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }

    public String getCompatibleAbility() {
        return compatibleAbility;
    }

    public void setCompatibleAbility(String compatibleAbility) {
        this.compatibleAbility = compatibleAbility == null ? null : compatibleAbility.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}