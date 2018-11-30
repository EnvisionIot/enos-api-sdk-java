package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventConfirmByIdResponse;
import com.envision.eeop.api.util.EnvisionHashMap;

import java.util.Map;


public class EventConfirmByIdRequest implements EnvisionRequest<EventConfirmByIdResponse> {
    private static final String API_METHOD = "/eventService/confirmEvent";

    private String eventId;
    private String confirmPerson;
    private String confirmValue;


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public EventConfirmByIdRequest(String eventId, String confirmPerson, String confirmValue) {
        this.eventId = eventId;
        this.confirmPerson = confirmPerson;
        this.confirmValue = confirmValue;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setConfirmPerson(String confirmPerson) {
        this.confirmPerson = confirmPerson;
    }

    public void setConfirmValue(String confirmValue) {
        this.confirmValue = confirmValue;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("eventId", eventId);
        txtParams.put("confirmPerson", confirmPerson);
        txtParams.put("confirmValue", confirmValue);
        return txtParams;
    }

    @Override
    public Class<EventConfirmByIdResponse> getResponseClass() {
        return EventConfirmByIdResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }

}
