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

public class DeleteTopologyByDeviceKeyRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/{deviceKey}/topology/subDecices";
    private static final String REQUEST_METHOD = "DELETE";
    
    private String orgId;
    private Boolean force;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSPathVariable(name = "deviceKey")
    private String deviceKey;
    @EnOSRequestBody
    private List<Device> subDevices;

    public DeleteTopologyByDeviceKeyRequest(String orgId, String productKey, String deviceKey, List<Device> subDevices) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.deviceKey = deviceKey;
        this.subDevices = subDevices;
        this.force = false;
    }

    public DeleteTopologyByDeviceKeyRequest(String orgId, String productKey, String deviceKey, List<Device> subDevices, Boolean force)
    {
        this(orgId, productKey, deviceKey, subDevices);
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