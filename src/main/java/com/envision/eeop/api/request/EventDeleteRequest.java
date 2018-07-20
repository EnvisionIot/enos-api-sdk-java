package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventDeleteResponse;
import com.envision.eeop.api.response.EventWriteResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;
import com.envision.event.bean.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;


public class EventDeleteRequest implements EnvisionRequest<EventDeleteResponse> {
    private static final String API_METHOD = "/eventService/deleteEvents";

    private String eventIds;
    private boolean deleteHistory;


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public EventDeleteRequest(List<String> eventIdList) {
        this.eventIds = StringUtils.listToString(eventIdList, ",");
    }

    public EventDeleteRequest(List<String> eventIdList, boolean deleteHistory) {
        this(eventIdList);
        this.deleteHistory = deleteHistory;
    }

    public void setEventIdList(List<String> eventIdList) {
        this.eventIds = StringUtils.listToString(eventIdList, ",");
    }

    public void setDeleteHistory(boolean deleteHistory) {
        this.deleteHistory = deleteHistory;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("eventIds", eventIds);
        txtParams.put("deleteHistory", deleteHistory);
        return txtParams;
    }

    @Override
    public Class<EventDeleteResponse> getResponseClass() {
        return EventDeleteResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }

}
