package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class DisableDeviceByAssetIdRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/connectService/devices/{assetId}/disable";
    private static final String REQUEST_METHOD = "PUT";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;

    public DisableDeviceByAssetIdRequest(String orgId, String assetId) {
        this.orgId = orgId;
        this.assetId = assetId;
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