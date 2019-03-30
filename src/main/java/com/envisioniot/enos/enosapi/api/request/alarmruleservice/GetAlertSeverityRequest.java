package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.AlertSeverity;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetAlertSeverityRequest extends EnOSRequest<EnOSResponse<AlertSeverity>> {
    private static final String API_METHOD = "/eventService/rules/alertSeverities/{severityId}";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "severityId")
    private String severityId;

    public GetAlertSeverityRequest(String orgId, String severityId) {
        this.orgId = orgId;
        this.severityId = severityId;
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