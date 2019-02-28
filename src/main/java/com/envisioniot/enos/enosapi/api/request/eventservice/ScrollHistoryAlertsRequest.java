package com.envisioniot.enos.enosapi.api.request.eventservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.HistoryEvent;
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

public class ScrollHistoryAlertsRequest extends EnOSRequest<EnOSResponse<EnOSPage<HistoryEvent>>> {
    private static final String API_METHOD = "/eventService/scrollHistoryAlerts";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private String modelId;
    
    private String deviceId;
    
    private Long timeFrom;
    
    private Long timeTo;
    
    private Long recoverTimeFrom;
    
    private Long recoverTimeTo;
    
    private Boolean isLocalTime;
    
    private Integer pageSize;
    
    private String pageToken;

    public ScrollHistoryAlertsRequest(String orgId, String modelId, String deviceId, Long timeFrom, Long timeTo, Long recoverTimeFrom, Long recoverTimeTo, Boolean isLocalTime, Integer pageSize, String pageToken) {
        this.orgId = orgId;
        this.modelId = modelId;
        this.deviceId = deviceId;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.recoverTimeFrom = recoverTimeFrom;
        this.recoverTimeTo = recoverTimeTo;
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