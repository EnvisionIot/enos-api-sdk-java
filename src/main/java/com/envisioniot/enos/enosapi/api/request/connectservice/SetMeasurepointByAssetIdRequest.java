package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.connectservice.MeasurepointSetInfo;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class SetMeasurepointByAssetIdRequest extends EnOSRequest<EnOSResponse<MeasurepointSetInfo>> {
    private static final String API_METHOD = "/connectService/devices/{assetId}/measurepoints/{measurepointId}/set";
    private static final String REQUEST_METHOD = "PUT";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;
    @EnOSPathVariable(name = "measurepointId")
    private String measurepointId;
    
    private Long timeout;
    @EnOSRequestBody
    private Object value;

    public SetMeasurepointByAssetIdRequest(String orgId, String assetId, String measurepointId, Long timeout, Object value) {
        this.orgId = orgId;
        this.assetId = assetId;
        this.measurepointId = measurepointId;
        this.timeout = timeout;
        this.value = value;
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