package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.AlertSeverity;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListAlertSeveritiesRequest extends EnOSRequest<EnOSResponse<EnOSPage<AlertSeverity>>> {
    private static final String API_METHOD = "/eventService/rules/alertSeverities";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private Integer pageToken;
    
    private Integer pageSize;

    public ListAlertSeveritiesRequest(String orgId, Integer pageToken, Integer pageSize) {
        this.orgId = orgId;
        this.pageToken = pageToken;
        this.pageSize = pageSize;
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