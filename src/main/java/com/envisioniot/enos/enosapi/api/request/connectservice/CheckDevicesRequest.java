package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.connectservice.DeviceKeyBatchCheckResult;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class CheckDevicesRequest extends EnOSRequest<EnOSResponse<DeviceKeyBatchCheckResult>> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/check";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    
    private String deviceKeys;

    public CheckDevicesRequest(String orgId, String productKey, String deviceKeys) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.deviceKeys = deviceKeys;
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