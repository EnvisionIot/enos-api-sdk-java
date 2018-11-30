package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.assetservice.TSLStringI18n;
import java.lang.Boolean;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class InsertNodeRequest extends EnOSRequest<EnOSResponse<String>> {
    private static final String API_METHOD = "/assetService/assetTrees/{assetTreeId}/nodes";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSPathVariable(name = "assetTreeId")
    private String assetTreeId;
    
    private String parentNodeId;
    
    private String preNodeId;
    
    private String assetId;
    
    private Boolean isDeviceInstance;
    
    private String modelId;
    @EnOSRequestBody
    private TSLStringI18n name;

    public InsertNodeRequest(String orgId, String assetTreeId, String parentNodeId, String preNodeId, String assetId, Boolean isDeviceInstance, String modelId, TSLStringI18n name) {
        this.orgId = orgId;
        this.assetTreeId = assetTreeId;
        this.parentNodeId = parentNodeId;
        this.preNodeId = preNodeId;
        this.assetId = assetId;
        this.isDeviceInstance = isDeviceInstance;
        this.modelId = modelId;
        this.name = name;
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