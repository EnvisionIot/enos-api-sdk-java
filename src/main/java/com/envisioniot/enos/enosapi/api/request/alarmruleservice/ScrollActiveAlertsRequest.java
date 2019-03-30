package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.google.gson.Gson;

import java.util.List;
import java.lang.Long;
import java.util.Map;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.ActiveAlert;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ScrollActiveAlertsRequest extends EnOSRequest<EnOSResponse<EnOSPage<ActiveAlert>>> {
    private static final String API_METHOD = "/eventService/alerts/activeAlerts/scroll";
    private static final String REQUEST_METHOD = "GET";

    
    private String orgId;
    
    private String eventIds;
    
    private String modelId;
    
    private String deviceIds;
    
    private String pointIds;
    
    private String ruleIds;
    
    private String tagMap;
    
    private Long startTime;
    
    private Long endTime;
    
    private Boolean isLocalTime;
    
    private Integer pageSize;
    
    private String pageToken;

    public ScrollActiveAlertsRequest(String orgId, String eventIds, String modelId, String deviceIds, String pointIds, String ruleIds, Map<String, String> tagMap, Long startTime, Long endTime, Boolean isLocalTime, Integer pageSize, String pageToken) {
        this.orgId = orgId;
        this.eventIds = eventIds;
        this.modelId = modelId;
        this.deviceIds = deviceIds;
        this.pointIds = pointIds;
        this.ruleIds = ruleIds;
        Gson gson = new Gson();
        this.tagMap = gson.toJson(tagMap);
        this.startTime = startTime;
        this.endTime = endTime;
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