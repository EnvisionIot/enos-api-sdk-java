package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.Map;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetDeviceStatusByAssetIdsRequest extends EnOSRequest<EnOSResponse<Map<String, String>>> {
    private static final String API_METHOD = "/connectService/devices/status";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    
    private String assetIds;

    public GetDeviceStatusByAssetIdsRequest(String orgId, String assetIds) {
        this.orgId = orgId;
        this.assetIds = assetIds;
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