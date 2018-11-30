package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.annotation.EnOSPathVariable;
import com.envisioniot.enos.enosapi.common.exception.EnOSRuleException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

public class DeleteAssetRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/assetService/assets/{assetId}";
    private static final String REQUEST_METHOD = "DELETE";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;

    public DeleteAssetRequest(String orgId, String assetId) {
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