package com.envisioniot.enos.enosapi.api.request.dataservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.Map;
import java.lang.Object;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetAssetsLatestDataRequest extends EnOSRequest<EnOSResponse<EnOSPage<Map<String, Object>>>> {
    private static final String API_METHOD = "/dataService/assets/latest/measurepoints";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private String assetIds;
    
    private String measurepoints;
    
    private Integer timeWindow;

    public GetAssetsLatestDataRequest(String orgId, String assetIds, String measurepoints, Integer timeWindow) {
        this.orgId = orgId;
        this.assetIds = assetIds;
        this.measurepoints = measurepoints;
        this.timeWindow = timeWindow;
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