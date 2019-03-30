package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AlertContent implements Serializable {

    private static final long serialVersionUID = 3818845922348519422L;
    /**
     * system id, auto generate
     */

    private String contentId;
    private StringI18n contentName;
    private StringI18n contentDesc;
    private String modelId;
    private Map<String,String> tag = new HashMap<>();
    private String orgId;
    private String appId;
    private String updatePerson;
    private long updateTime;//更新时间，数据库会在更新的时候自动更新
    private AlertType alertType;
    private AlertType subAlertType;

    public AlertContent() {
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public StringI18n getContentName() {
        return contentName;
    }

    public void setContentName(StringI18n contentName) {
        this.contentName = contentName;
    }

    public StringI18n getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(StringI18n contentDesc) {
        this.contentDesc = contentDesc;
    }


    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

   
    public Map<String, String> getTag() {
        return tag;
    }

    public void setTag(Map<String, String> tag) {
        this.tag = tag;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public AlertType getSubAlertType() {
        return subAlertType;
    }

    public void setSubAlertType(AlertType subAlertType) {
        this.subAlertType = subAlertType;
    }

    @Override
    public String toString() {
        return "AlertContent{" +
                ", contentIdv=" + contentId +
                ", contentDesc='" + contentDesc +
                ", orgId='" + orgId +
                ", appId='" + appId +
                '}';
    }
}
