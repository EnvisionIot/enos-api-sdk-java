package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import java.util.Map;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.ActiveAlert;
import com.envisioniot.enos.enosapi.common.exception.EnOSRuleException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.google.gson.Gson;

public class ListActiveAlertsRequest extends EnOSRequest<EnOSResponse<EnOSPage<ActiveAlert>>> {
    private static final String API_METHOD = "/eventService/alerts/activeAlerts/list";
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
    
    private Integer pageToken;
    
    private Integer pageSize;

    public ListActiveAlertsRequest(String orgId, String eventIds, String modelId, String deviceIds, String pointIds, String ruleIds, Map<String, String> tagMap, Long startTime, Long endTime, Boolean isLocalTime, Integer pageToken, Integer pageSize) {
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