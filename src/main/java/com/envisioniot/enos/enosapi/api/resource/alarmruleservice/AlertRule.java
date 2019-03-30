package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;



import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AlertRule implements Serializable {

    private static final long serialVersionUID = -2531110534182679187L;
    /**
     * system id, auto generate
     */
    private Integer ruleId;
    private StringI18n ruleName;
    private StringI18n ruleDesc;
    private String modelId;
    private StringI18n modelName;
    private String pointId;
    private String conditionSchema;
    private String severityId;
    private StringI18n severityName;
    private String contentId;
    private StringI18n contentName;
    private String typeId;
    private StringI18n typeName;
    private String subTypeId;
    private StringI18n subTypeName;
    private Map<String,String> tag = new HashMap<>();
    private String orgId;
    private String appId;
    
    /**
     * 规则类型
     * true: 告警规则, false: 恢复规则
     */
    private Boolean isAlert = true;
    /**
     * rule level flag
     * 与config level flag共同决定规则是否启用
     */
    private Boolean enabled = true;
    private String updatePerson;
    private long updateTime;

    public AlertRule() {
    }
    
    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public StringI18n getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(StringI18n ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getSeverityId() {
        return severityId;
    }

    public String getConditionSchema() {
        return conditionSchema;
    }

    public void setConditionSchema(String conditionSchema) {
        this.conditionSchema = conditionSchema;
    }

    public String getContentId() {
        return contentId;
    }


    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public void setSeverityId(String severityId) {
        this.severityId = severityId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Boolean isEnabled() {
        return enabled;
    }



    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public StringI18n getRuleName() {
        return ruleName;
    }

    public void setRuleName(StringI18n ruleName) {
        this.ruleName = ruleName;
    }

    public String getModelId() {
        return modelId;
    }

    public StringI18n getModelName() {
        return modelName;
    }

    public void setModelName(StringI18n modelName) {
        this.modelName = modelName;
    }

    public StringI18n getSeverityName() {
        return severityName;
    }

    public void setSeverityName(StringI18n severityName) {
        this.severityName = severityName;
    }

    public StringI18n getContentName() {
        return contentName;
    }

    public void setContentName(StringI18n contentName) {
        this.contentName = contentName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public StringI18n getTypeName() {
        return typeName;
    }

    public void setTypeName(StringI18n typeName) {
        this.typeName = typeName;
    }

    public String getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(String subTypeId) {
        this.subTypeId = subTypeId;
    }

    public StringI18n getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(StringI18n subTypeName) {
        this.subTypeName = subTypeName;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

  

    public void setAlert(Boolean alert) {
        isAlert = alert;
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

    public Boolean isAlert() {
        return isAlert;
    }



    // 不支持恢复类
//    public void setAlert(boolean alert) {
//        isAlert = alert;
//    }

    @Override
    public String toString() {
        return "AlertRule [ruleId=" + ruleId + ", modelId=" + modelId + ", pointId=" + pointId + ", severityId="
                + severityId + ", contentId=" + contentId + ", typeId=" + typeId + ", subTypeId=" + subTypeId
                + ", orgId=" + orgId + ", appId=" + appId + "]";
    }
}
