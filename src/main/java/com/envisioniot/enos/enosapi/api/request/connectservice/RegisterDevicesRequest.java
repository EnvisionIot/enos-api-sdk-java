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

public class RegisterDevicesRequest extends EnOSRequest<EnOSResponse<List<Device>>> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSRequestBody
    private List<Device> devices;

    public RegisterDevicesRequest(String orgId, String productKey, List<Device> devices) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.devices = devices;
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