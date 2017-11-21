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

    private int id;

    private String mdmId;

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

    public String getMdmId() {
        return mdmId;
    }

    public void setMdmId(String mdmId) {
        this.mdmId = mdmId;
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

        EventRule rule = (EventRule) o;

        if (id != rule.id) return false;
        if (interval != rule.interval) return false;
        if (isValid != rule.isValid) return false;
        if (!mdmId.equals(rule.mdmId)) return false;
        if (!category.equals(rule.category)) return false;
        if (!warnType.equals(rule.warnType)) return false;
        if (!childWarnType.equals(rule.childWarnType)) return false;
        if (!code.equals(rule.code)) return false;
        if (!threshold.equals(rule.threshold)) return false;
        if (attributes != null ? !attributes.equals(rule.attributes) : rule.attributes != null) return false;
        if (!ruleDesc.equals(rule.ruleDesc)) return false;
        return operator != null ? operator.equals(rule.operator) : rule.operator == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + mdmId.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + warnType.hashCode();
        result = 31 * result + childWarnType.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + interval;
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
                ", mdmId='" + mdmId + '\'' +
                ", category='" + category + '\'' +
                ", warnType='" + warnType + '\'' +
                ", childWarnType='" + childWarnType + '\'' +
                ", code='" + code + '\'' +
                ", interval=" + interval +
                ", threshold='" + threshold + '\'' +
                ", attributes='" + attributes + '\'' +
                ", isValid=" + isValid +
                ", ruleDesc='" + ruleDesc + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}