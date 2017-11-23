package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventRuleInvalidResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
public class EventRuleInvalidRequest implements EnvisionRequest<EventRuleInvalidResponse> {

    private static final String APP_METHOD = "/eventService/invalidrule";

    private String ruleIds;

    public String getRuleIds() {
        return ruleIds;
    }

    public void setRuleIds(String ruleIds) {
        this.ruleIds = ruleIds;
    }

    public EventRuleInvalidRequest(String ruleIds) {
        this.ruleIds = ruleIds;
    }

    @Override
    public String getApiMethodName() {
        return APP_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("ruleIds", ruleIds);
        return txtParams;
    }

    @Override
    public Class<EventRuleInvalidResponse> getResponseClass() {
        return EventRuleInvalidResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(ruleIds, "ruleIds");
    }
}
