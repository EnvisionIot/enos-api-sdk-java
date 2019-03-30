package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import java.lang.Long;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.EventResultInfo;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class CloseActiveAlertsRequest extends EnOSRequest<EnOSResponse<EventResultInfo>> {
    private static final String API_METHOD = "/eventService/alert/closeActiveAlerts";
    private static final String REQUEST_METHOD = "PUT";

    
    private String orgId;
    
    private String eventIds;
    
    private Long recoverTime;

    public CloseActiveAlertsRequest(String orgId, String eventIds, Long recoverTime) {
        this.orgId = orgId;
        this.eventIds = eventIds;
        this.recoverTime = recoverTime;
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