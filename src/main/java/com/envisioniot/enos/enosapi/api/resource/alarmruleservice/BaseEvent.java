package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础对象时间，无论是正在告警对象，还是历史库对象都继承与这个类
 * 2018年12月22日
 * @author lang.ming
 *
 */
public class BaseEvent implements Serializable
{
    public static final int EVENT_TYPE_RECOVER = 0;
    public static final int EVENT_TYPE_OCCUR = 1;
    
    private static final long serialVersionUID = 1L;
    private String eventId;
    private String orgId;
    private String deviceId; // 设备ID
    private String modelId;
    private String pointId;
    private Integer hitRuleId;
    private Object value; // json对象
    private Long time;
    private Long localTime;

    private Integer severityId;
    private TSLStringI18n severityDesc;
    private Integer typeId;
    private TSLStringI18n typeDesc;
    private Integer subTypeId;
    private TSLStringI18n subTypeDesc;
    private Integer contentId;
    private TSLStringI18n contentDesc; // 告警内容, 由内容模板生成

    private Integer eventType; // 1:告警事件,0:告警恢复事件,其他值:普通事件
    private Map<String, String> ruleTag = new HashMap<>();
    private TSLStringI18n ruleDesc;// description in alarm-rule-table,eg:{"zh-CN":"母线电压波动"}

    public String getEventId()
    {
        return eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getModelId()
    {
        return modelId;
    }

    public void setModelId(String modelId)
    {
        this.modelId = modelId;
    }

    public String getPointId()
    {
        return pointId;
    }

    public void setPointId(String pointId)
    {
        this.pointId = pointId;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public Integer getSeverityId()
    {
        return severityId;
    }

    public TSLStringI18n getSeverityDesc()
    {
        return severityDesc;
    }

    public void setSeverityDesc(TSLStringI18n severityDesc)
    {
        this.severityDesc = severityDesc;
    }

    public Integer getTypeId()
    {
        return typeId;
    }

    public TSLStringI18n getTypeDesc()
    {
        return typeDesc;
    }

    public void setTypeDesc(TSLStringI18n typeDesc)
    {
        this.typeDesc = typeDesc;
    }

    public Integer getSubTypeId()
    {
        return subTypeId;
    }

    public TSLStringI18n getSubTypeDesc()
    {
        return subTypeDesc;
    }

    public void setSubTypeDesc(TSLStringI18n subTypeDesc)
    {
        this.subTypeDesc = subTypeDesc;
    }

    public Integer getContentId()
    {
        return contentId;
    }

    public TSLStringI18n getContentDesc()
    {
        return contentDesc;
    }

    public void setContentDesc(TSLStringI18n contentDesc)
    {
        this.contentDesc = contentDesc;
    }

    public TSLStringI18n getRuleDesc()
    {
        return ruleDesc;
    }

    public void setRuleDesc(TSLStringI18n ruleDesc)
    {
        this.ruleDesc = ruleDesc;
    }

    public Map<String, String> getRuleTag()
    {
        return ruleTag;
    }

    public void setRuleTag(Map<String, String> ruleTag)
    {
        this.ruleTag = ruleTag;
    }

    public Integer getHitRuleId()
    {
        return hitRuleId;
    }

    public void setHitRuleId(Integer hitRuleId)
    {
        this.hitRuleId = hitRuleId;
    }

    public void setSeverityId(Integer severityId)
    {
        this.severityId = severityId;
    }

    public void setTypeId(Integer typeId)
    {
        this.typeId = typeId;
    }

    public void setSubTypeId(Integer subTypeId)
    {
        this.subTypeId = subTypeId;
    }

    public void setContentId(Integer contentId)
    {
        this.contentId = contentId;
    }

    public Integer getEventType()
    {
        return eventType;
    }

    public void setEventType(Integer eventType)
    {
        this.eventType = eventType;
    }

    public Long getTime()
    {
        return time;
    }

    public void setTime(Long time)
    {
        this.time = time;
    }

    public Long getLocalTime()
    {
        return localTime;
    }

    public void setLocalTime(Long localTime)
    {
        this.localTime = localTime;
    }

    public BaseEvent()
    {
        super();
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "eventId='" + eventId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", modelId='" + modelId + '\'' +
                ", pointId='" + pointId + '\'' +
                ", hitRuleId=" + hitRuleId +
                ", value='" + value + '\'' +
                ", time=" + time +
                ", localTime=" + localTime +
                ", severityId=" + severityId +
                ", severityDesc=" + severityDesc +
                ", typeId=" + typeId +
                ", typeDesc=" + typeDesc +
                ", subTypeId=" + subTypeId +
                ", subTypeDesc=" + subTypeDesc +
                ", contentId=" + contentId +
                ", contentDesc=" + contentDesc +
                ", eventType=" + eventType +
                ", ruleTag=" + ruleTag +
                ", ruleDesc=" + ruleDesc +
                '}';
    }
}
