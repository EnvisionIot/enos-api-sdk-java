package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.domain.EventRule;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventRuleInsertResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
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
public class EventRuleInsertRequest implements EnvisionRequest<EventRuleInsertResponse> {

    private static final String APP_METHOD = "/eventService/insertrule";

    private static final Type inputEventRuleList = new TypeToken<List<EventRule>>(){}.getType();

    private List<EventRule> ruleList;

    public EventRuleInsertRequest(List<EventRule> ruleList) {
        this.ruleList = ruleList;
    }

    @Override
    public String getApiMethodName() {
        return APP_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("eventRules", JsonParser.toJson(ruleList, inputEventRuleList));
        return txtParams;
    }

    @Override
    public Class<EventRuleInsertResponse> getResponseClass() {
        return EventRuleInsertResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(ruleList, "eventRules");
    }
}
