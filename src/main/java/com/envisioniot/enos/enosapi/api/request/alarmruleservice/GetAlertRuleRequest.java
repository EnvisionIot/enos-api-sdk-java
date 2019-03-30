package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.AlertRule;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetAlertRuleRequest extends EnOSRequest<EnOSResponse<AlertRule>> {
    private static final String API_METHOD = "/eventService/rules/alertRules/{ruleId}";
    private static final String REQUEST_METHOD = "GET";

    
    private String orgId;
    @EnOSPathVariable(name = "ruleId")
    private Integer ruleId;

    public GetAlertRuleRequest(String orgId, Integer ruleId) {
        this.orgId = orgId;
        this.ruleId = ruleId;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public String getRequestMethod() {
        return REQUEST_METHOD;
    }

    @Override
    public void check() throws EnOSRuleException {
        // super.check();
    }
}