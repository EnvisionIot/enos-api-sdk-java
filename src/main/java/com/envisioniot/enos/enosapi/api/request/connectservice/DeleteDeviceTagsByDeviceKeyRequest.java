package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class DeleteDeviceTagsByDeviceKeyRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/{deviceKey}/tags";
    private static final String REQUEST_METHOD = "DELETE";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSPathVariable(name = "deviceKey")
    private String deviceKey;
    
    private String tagKeys;

    public DeleteDeviceTagsByDeviceKeyRequest(String orgId, String productKey, String deviceKey, String tagKeys) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.deviceKey = deviceKey;
        this.tagKeys = tagKeys;
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