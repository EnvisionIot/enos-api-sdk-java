package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventQueryByIdsResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;


public class EventQueryByIdsRequest implements EnvisionRequest<EventQueryByIdsResponse> {
    private static final String API_METHOD = "/eventService/getEventsByEventIDs";

    private String eventIds;


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public EventQueryByIdsRequest(List<String> eventIdList) {
        this.eventIds = StringUtils.listToString(eventIdList, ",");
    }

    public void setEventIdList(List<String> eventIdList) {
        this.eventIds = StringUtils.listToString(eventIdList, ",");
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("eventIds", eventIds);

        return txtParams;
    }

    @Override
    public Class<EventQueryByIdsResponse> getResponseClass() {
        return EventQueryByIdsResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }

}
