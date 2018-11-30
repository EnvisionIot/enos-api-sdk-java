package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.connectservice.DeviceCertApplyResultInfo;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ApplyCertificateByDeviceKeyRequest extends EnOSRequest<EnOSResponse<DeviceCertApplyResultInfo>> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/{deviceKey}/certificates/apply";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSPathVariable(name = "deviceKey")
    private String deviceKey;
    @EnOSRequestBody
    private String csr;

    public ApplyCertificateByDeviceKeyRequest(String orgId, String productKey, String deviceKey, String csr) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.deviceKey = deviceKey;
        this.csr = csr;
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