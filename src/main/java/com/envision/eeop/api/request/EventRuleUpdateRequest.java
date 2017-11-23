package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.domain.EventRule;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventRuleUpdateResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
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
public class EventRuleUpdateRequest implements EnvisionRequest<EventRuleUpdateResponse> {

    private static final String APP_METHOD = "/eventService/updaterule";

    private static final Type inputEventRuleList = new TypeToken<List<EventRule>>(){}.getType();
    private static final Gson gson = new Gson();

    private List<EventRule> ruleList;

    public EventRuleUpdateRequest(List<EventRule> ruleList) {
        this.ruleList = ruleList;
    }

    @Override
    public String getApiMethodName() {
        return APP_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("ruleList", gson.toJson(ruleList, inputEventRuleList));

        return txtParams;
    }

    @Override
    public Class<EventRuleUpdateResponse> getResponseClass() {
        return EventRuleUpdateResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(ruleList, "ruleList");
    }

    public List<EventRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<EventRule> ruleList) {
        this.ruleList = ruleList;
    }
}

