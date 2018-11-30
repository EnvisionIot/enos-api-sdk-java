package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventSRGenerateResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.bo.EventSR;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
public class EventSRGenerateRequest implements EnvisionRequest<EventSRGenerateResponse> {
    private static final String APP_METHOD = "/eventService/geneventsr";

    private static final Gson gson = new Gson();
    private static final Type inputEventSRList = new TypeToken<List<EventSR>>(){}.getType();

    private List<EventSR> eventSRList;

    public List<EventSR> getEventSRList() {
        return eventSRList;
    }

    public void setEventSRList(List<EventSR> eventSRList) {
        this.eventSRList = eventSRList;
    }

    @Override
    public String getApiMethodName() {
        return APP_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("eventSRList", gson.toJson(eventSRList, inputEventSRList));
        return txtParams;
    }

    @Override
    public Class<EventSRGenerateResponse> getResponseClass() {
        return EventSRGenerateResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(eventSRList, "eventSRList");
    }
}
