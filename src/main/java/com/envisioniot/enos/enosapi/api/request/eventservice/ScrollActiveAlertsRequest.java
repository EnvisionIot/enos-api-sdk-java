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

public class ScrollActiveAlertsRequest extends EnOSRequest<EnOSResponse<EnOSPage<AlarmingEvent>>> {
    private static final String API_METHOD = "/eventService/scrollActiveAlerts";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private String modelId;
    
    private String deviceId;
    
    private Long timeFrom;
    
    private Long timeTo;
    
    private Boolean isLocalTime;
    
    private Integer pageSize;
    
    private String pageToken;

    public ScrollActiveAlertsRequest(String orgId, String modelId, String deviceId, Long timeFrom, Long timeTo, Boolean isLocalTime, Integer pageSize, String pageToken) {
        this.orgId = orgId;
        this.modelId = modelId;
        this.deviceId = deviceId;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.isLocalTime = isLocalTime;
        this.pageSize = pageSize;
        this.pageToken = pageToken;
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