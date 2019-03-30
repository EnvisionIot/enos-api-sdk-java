package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class DeleteActiveAlertsRequest extends EnOSRequest<EnOSResponse<Integer>> {
    private static final String API_METHOD = "/eventService/alerts/activeAlerts";
    private static final String REQUEST_METHOD = "DELETE";

    
    private String orgId;
    
    private String eventIds;

    public DeleteActiveAlertsRequest(String orgId, String eventIds) {
        this.orgId = orgId;
        this.eventIds = eventIds;
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