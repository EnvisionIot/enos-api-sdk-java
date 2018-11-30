package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.Map;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class UpdateDeviceTagsByAssetIdRequest extends EnOSRequest<EnOSResponse<Map<String, String>>> {
    private static final String API_METHOD = "/connectService/devices/{assetId}/tags";
    private static final String REQUEST_METHOD = "PUT";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;
    
    private boolean isOverwrite;
    @EnOSRequestBody
    private Map<String, String> tags;

    public UpdateDeviceTagsByAssetIdRequest(String orgId, String assetId, boolean isOverwrite, Map<String, String> tags) {
        this.orgId = orgId;
        this.assetId = assetId;
        this.isOverwrite = isOverwrite;
        this.tags = tags;
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