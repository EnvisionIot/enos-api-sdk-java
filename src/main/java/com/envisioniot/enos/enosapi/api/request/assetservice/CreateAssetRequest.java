package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.api.resource.assetservice.Asset;
import com.envisioniot.enos.enosapi.common.annotation.EnOSRequestBody;
import com.envisioniot.enos.enosapi.common.exception.EnOSRuleException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

public class CreateAssetRequest extends EnOSRequest<EnOSResponse<Asset>> {
    private static final String API_METHOD = "/assetService/assets";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSRequestBody
    private Asset asset;

    public CreateAssetRequest(String orgId, Asset asset) {
        this.orgId = orgId;
        this.asset = asset;
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