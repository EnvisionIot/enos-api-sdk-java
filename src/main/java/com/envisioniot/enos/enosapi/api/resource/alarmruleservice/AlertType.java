package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AlertType implements Serializable {
    private static final long serialVersionUID = -3691819743908230413L;
    /**
     * system id, auto generate
     */
    private String typeId;
    private StringI18n typeName;
    private StringI18n typeDesc;
    private String parentTypeId;
    private Map<String,String> tag = new HashMap<>();
    private String orgId;
    private String appId;

    private String updatePerson;
    private long updateTime;

    public AlertType() {
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public StringI18n getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(StringI18n typeDesc) {
        this.typeDesc = typeDesc;
    }

    public StringI18n getTypeName() {
        return typeName;
    }

    public void setTypeName(StringI18n typeName) {
        this.typeName = typeName;
    }

    public String getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
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
        return "AlertType{" +
                ", typeId=" + typeId +
                ", parentTypeId='" + parentTypeId +
                ", orgId='" + orgId +
                ", appId='" + appId +
                '}';
    }
}
