package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;

import java.io.Serializable;
import java.util.Map;

public class AlertSeverity implements Serializable {
    private static final long serialVersionUID = -3691819743908230413L;
    /**
     * system id, auto generate
     */
    private String severityId;
    private StringI18n severityName;
    private StringI18n severityDesc;
    private Map<String, String> tag;
    //OU_ID和APP_ID只能有一个有具体数值，另外一个必然为*
    private String orgId;
    private String appId;

    private String updatePerson;
    private long updateTime;

    public AlertSeverity() {
    }

    public String getSeverityId() {
        return severityId;
    }
    public void setSeverityId(String severityId) {
        this.severityId = severityId;
    }

    public StringI18n getSeverityName() {
        return severityName;
    }

    public void setSeverityName(StringI18n severityName) {
        this.severityName = severityName;
    }

    public StringI18n getSeverityDesc() {
        return severityDesc;
    }

    public void setSeverityDesc(StringI18n severityDesc) {
        this.severityDesc = severityDesc;
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

    @Override
    public String toString() {
        return "AlertSeverity{" +
                ", severityId='" + severityId +
                ", severityDesc='" + severityDesc +
                ", orgId='" + orgId +
                ", appId='" + appId +
                '}';
    }
}
