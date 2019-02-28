package com.envisioniot.enos.enosapi.api.request.eventservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.AlarmingEvent;
import java.lang.Long;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListActiveAlertsRequest extends EnOSRequest<EnOSResponse<EnOSPage<AlarmingEvent>>> {
    private static final String API_METHOD = "/eventService/listActiveAlerts";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private String modelId;
    
    private String deviceId;
    
    private Long timeFrom;
    
    private Long timeTo;
    
    private Boolean isLocalTime;
    
    private Integer pageToken;
    
    private Integer pageSize;

    public ListActiveAlertsRequest(String orgId, String modelId, String deviceId, Long timeFrom, Long timeTo, Boolean isLocalTime, Integer pageToken, Integer pageSize) {
        this.orgId = orgId;
        this.modelId = modelId;
        this.deviceId = deviceId;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.isLocalTime = isLocalTime;
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