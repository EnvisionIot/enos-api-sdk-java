package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class UpdateHistoryAlertTagsRequest extends EnOSRequest<EnOSResponse<Integer>> {
    private static final String API_METHOD = "/eventService/alerts/historyAlerts/tags";
    private static final String REQUEST_METHOD = "PUT";
    
    private String orgId;
    
    private String eventIds;
    @EnOSRequestBody
    private Map<String, String> tagMap;

    public UpdateHistoryAlertTagsRequest(String orgId, String eventIds, Map<String, String> tagMap) {
        this.orgId = orgId;
        this.eventIds = eventIds;
        this.tagMap = tagMap;
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