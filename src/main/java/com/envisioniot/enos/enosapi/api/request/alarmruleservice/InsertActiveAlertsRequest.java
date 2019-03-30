package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.EventResultInfo;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.ActiveAlert;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class InsertActiveAlertsRequest extends EnOSRequest<EnOSResponse<EventResultInfo>> {
    private static final String API_METHOD = "/eventService/alerts/activeAlerts";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSRequestBody
    private List<ActiveAlert> activeAlertList;

    public InsertActiveAlertsRequest(String orgId, List<ActiveAlert> activeAlertList) {
        this.orgId = orgId;
        this.activeAlertList = activeAlertList;
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