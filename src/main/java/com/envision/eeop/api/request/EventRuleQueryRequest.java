package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventRuleQueryResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
public class EventRuleQueryRequest implements EnvisionRequest<EventRuleQueryResponse> {
    private static final String APP_METHOD = "/eventService/queryrule";

    private String mdmIdList;

    boolean includeInvalid;

    public EventRuleQueryRequest(String mdmIdList, boolean includeInvalid) {
        this.mdmIdList = mdmIdList;
        this.includeInvalid = includeInvalid;
    }

    @Override
    public String getApiMethodName() {
        return APP_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmIdList", mdmIdList);
        txtParams.put("includeInvalid", String.valueOf(includeInvalid));
        return txtParams;
    }

    @Override
    public Class<EventRuleQueryResponse> getResponseClass() {
        return EventRuleQueryResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(mdmIdList, "mdmIdList");
    }
}

