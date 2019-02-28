package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class DeleteDeviceByDeviceKeyRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/{deviceKey}";
    private static final String REQUEST_METHOD = "DELETE";
    
    private String orgId;
    private Boolean force;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSPathVariable(name = "deviceKey")
    private String deviceKey;

    public DeleteDeviceByDeviceKeyRequest(String orgId, String productKey, String deviceKey) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.deviceKey = deviceKey;
        this.force = false;
    }

    public DeleteDeviceByDeviceKeyRequest(String orgId, String productKey, String deviceKey, Boolean force) {
        this(orgId, productKey, deviceKey);
        this.force = force;
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