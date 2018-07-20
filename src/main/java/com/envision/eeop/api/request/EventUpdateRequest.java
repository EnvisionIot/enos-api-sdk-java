package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventUpdateResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.event.bean.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;


public class EventUpdateRequest implements EnvisionRequest<EventUpdateResponse> {
    private static final String API_METHOD = "/eventService/updateEvents";

    private List<Event> eventList;


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public EventUpdateRequest(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        txtParams.put("events", gson.toJson(eventList));
        return txtParams;
    }

    @Override
    public Class<EventUpdateResponse> getResponseClass() {
        return EventUpdateResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }

}
