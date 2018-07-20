package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventWriteResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.event.bean.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;


public class EventWriteRequest implements EnvisionRequest<EventWriteResponse> {
    private static final String API_METHOD = "/eventService/insertEvents";

    private List<Event> eventList;


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public EventWriteRequest(List<Event> eventList) {
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
    public Class<EventWriteResponse> getResponseClass() {
        return EventWriteResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }

}
