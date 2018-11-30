package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.api.resource.connectservice.Device;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListTopologyByDeviceKeyRequest extends EnOSRequest<EnOSResponse<List<Device>>> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/{deviceKey}/topology/subDecices";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSPathVariable(name = "deviceKey")
    private String deviceKey;

    public ListTopologyByDeviceKeyRequest(String orgId, String productKey, String deviceKey) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.deviceKey = deviceKey;
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