package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.api.resource.connectservice.MeasurepointStatus;
import com.envisioniot.enos.enosapi.common.annotation.EnOSPathVariable;
import com.envisioniot.enos.enosapi.common.exception.EnOSRuleException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

import java.util.List;

public class GetMeasurepointsDataByAssetIDRequest extends EnOSRequest<EnOSResponse<List<MeasurepointStatus>>> {
    private static final String API_METHOD = "/connectService/devices/{assetId}/measurepoints/latestData";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;

    public GetMeasurepointsDataByAssetIDRequest(String orgId, String assetId) {
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