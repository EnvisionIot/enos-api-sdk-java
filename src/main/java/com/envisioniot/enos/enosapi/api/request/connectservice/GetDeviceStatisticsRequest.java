package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.connectservice.DeviceStatistics;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetDeviceStatisticsRequest extends EnOSRequest<EnOSResponse<DeviceStatistics>> {
    private static final String API_METHOD = "/connectService/statistics/devices";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private String productKey;

    public GetDeviceStatisticsRequest(String orgId, String productKey) {
        this.orgId = orgId;
        this.productKey = productKey;
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