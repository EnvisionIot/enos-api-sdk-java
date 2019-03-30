package com.envisioniot.enos.enosapi.api.request.alarmruleservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.EventResultInfo;
import java.lang.String;
import com.envisioniot.enos.enosapi.api.resource.alarmruleservice.HistoryAlert;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class InsertHistoryAlertsRequest extends EnOSRequest<EnOSResponse<EventResultInfo>> {
    private static final String API_METHOD = "/eventService/alerts/historyAlerts";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSRequestBody
    private List<HistoryAlert> historyAlertList;

    public InsertHistoryAlertsRequest(String orgId, List<HistoryAlert> historyAlertList) {
        this.orgId = orgId;
        this.historyAlertList = historyAlertList;
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