package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionPaginationRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventSRQueryResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.bo.EventSRQuery;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
public class EventSRQueryRequest extends EnvisionPaginationRequest<EventSRQueryResponse> {
    private static final String API_METHOD = "/eventService/querysr";

    private static Type eventSRQueryTypeToken = new TypeToken<EventSRQuery>(){}.getType();
    private static final Gson gson = new Gson();

    private EventSRQuery query;

    public EventSRQueryRequest(EventSRQuery query) {
        this.query = query;
    }

    public EventSRQueryRequest(EventSRQuery query, int pageNo, int pageSize) {
        this.query = query;
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("querysr", gson.toJson(query, eventSRQueryTypeToken));
        txtParams.putAll(getPaginationParams());
        return txtParams;
    }

    @Override
    public Class<EventSRQueryResponse> getResponseClass() {
        return EventSRQueryResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(query, "querysr");
    }

    public EventSRQuery getQuery() {
        return query;
    }

    public void setQuery(EventSRQuery query) {
        this.query = query;
    }
}

