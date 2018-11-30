package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.api.resource.connectservice.MeasurepointStatus;
import com.envisioniot.enos.enosapi.common.annotation.EnOSPathVariable;
import com.envisioniot.enos.enosapi.common.exception.EnOSRuleException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

import java.util.List;

public class GetMeasurepointsDataByDeviceKeyRequest extends EnOSRequest<EnOSResponse<List<MeasurepointStatus>>> {
    private static final String API_METHOD = "/connectService/products/{productKey}/devices/{deviceKey}/measurepoints/latestData";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    @EnOSPathVariable(name = "deviceKey")
    private String deviceKey;

    public GetMeasurepointsDataByDeviceKeyRequest(String orgId, String productKey, String deviceKey) {
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