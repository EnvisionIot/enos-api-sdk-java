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

public class GetAssetsGenericDataRequest extends EnOSRequest<EnOSResponse<EnOSPage<Map<String, Object>>>> {
    private static final String API_METHOD = "/dataService/assets/tsdb/generic/measurepoints";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private String modelId;
    
    private String assetIds;
    
    private String measurepoints;
    
    private String startTime;
    
    private String endTime;
    
    private Integer pageSize;

    public GetAssetsGenericDataRequest(String orgId, String modelId, String assetIds, String measurepoints, String startTime, String endTime, Integer pageSize) {
        this.orgId = orgId;
        this.modelId = modelId;
        this.assetIds = assetIds;
        this.measurepoints = measurepoints;
        this.startTime = startTime;
        this.endTime = endTime;
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