package com.envision.eeop.api.domain;

import java.io.Serializable;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
public class EventRule implements Serializable {
    private static final long serialVersionUID = 566953763637154337L;

    public EventRule() {
    }

    private int id;

    /**
     * 客户ID
     */
    private String customerId;

    /**
     * 领域类型, 风:21, 光:22
     */
    private String category;

    /**
     * 事件类型
     */
    private String warnType;

    /**
     * 事件子类型
     */
    private String childWarnType;

    /**
     * 告警故障代码
     */
    private String code;

    /**
     * SR复位时效
     */
    private int interval;

    private String pointId;
    private String deviceId;
    private String siteId;

    /**
     * 触发阈值, 格式为json
     * {"24h":100, "168h":100}
     */
    private String threshold;

    /**
     * 额外属性列表，格式为json
     * {"attr1":"val1", "attr2":"val2" ...}
     */
    private String attributes;

    /**
     * 是否有效规则标识
     */
    private int isValid;

    /**
     * 描述
     * {"zh-CN":"中文描述"， "en-US":"english"}
     */
    private String ruleDesc;

    /**
     * 操作人
     */
    private String operator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    public String getChildWarnType() {
        return childWarnType;
    }

    public void setChildWarnType(String childWarnType) {
        this.childWarnType = childWarnType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventRule eventRule = (EventRule) o;

        if (id != eventRule.id) return false;
        if (interval != eventRule.interval) return false;
        if (isValid != eventRule.isValid) return false;
        if (!customerId.equals(eventRule.customerId)) return false;
        if (!category.equals(eventRule.category)) return false;
        if (!warnType.equals(eventRule.warnType)) return false;
        if (!childWarnType.equals(eventRule.childWarnType)) return false;
        if (!code.equals(eventRule.code)) return false;
        if (pointId != null ? !pointId.equals(eventRule.pointId) : eventRule.pointId != null) return false;
        if (deviceId != null ? !deviceId.equals(eventRule.deviceId) : eventRule.deviceId != null) return false;
        if (siteId != null ? !siteId.equals(eventRule.siteId) : eventRule.siteId != null) return false;
        if (!threshold.equals(eventRule.threshold)) return false;
        if (attributes != null ? !attributes.equals(eventRule.attributes) : eventRule.attributes != null) return false;
        if (!ruleDesc.equals(eventRule.ruleDesc)) return false;
        return operator != null ? operator.equals(eventRule.operator) : eventRule.operator == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customerId.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + warnType.hashCode();
        result = 31 * result + childWarnType.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + interval;
        result = 31 * result + (pointId != null ? pointId.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + threshold.hashCode();
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + isValid;
        result = 31 * result + ruleDesc.hashCode();
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventRule{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", category='" + category + '\'' +
                ", warnType='" + warnType + '\'' +
                ", childWarnType='" + childWarnType + '\'' +
                ", code='" + code + '\'' +
                ", interval=" + interval +
                ", pointId='" + pointId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", siteId='" + siteId + '\'' +
                ", threshold='" + threshold + '\'' +
                ", attributes='" + attributes + '\'' +
                ", isValid=" + isValid +
                ", ruleDesc='" + ruleDesc + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}