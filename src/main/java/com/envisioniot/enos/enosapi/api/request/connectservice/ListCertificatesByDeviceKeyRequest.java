package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import com.envisioniot.enos.enosapi.api.resource.connectservice.DeviceCertSummaryInfo;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListCertificatesByDeviceKeyRequest extends EnOSRequest<EnOSResponse<List<DeviceCertSummaryInfo>>> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/{deviceKey}/certificates/list";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSPathVariable(name = "deviceKey")
    private String deviceKey;

    public ListCertificatesByDeviceKeyRequest(String orgId, String productKey, String deviceKey) {
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