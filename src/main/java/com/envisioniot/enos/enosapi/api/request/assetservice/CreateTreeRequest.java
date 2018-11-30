package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.assetservice.TSLStringI18n;
import com.envisioniot.enos.enosapi.api.resource.assetservice.Tree;
import java.lang.Boolean;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class CreateTreeRequest extends EnOSRequest<EnOSResponse<Tree>> {
    private static final String API_METHOD = "/assetService/assetTrees";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    
    private String assetId;
    
    private String modelId;
    @EnOSRequestBody
    private TSLStringI18n name;
    
    private Boolean isDeviceInstance;

    public CreateTreeRequest(String orgId, String assetId, String modelId, TSLStringI18n name, Boolean isDeviceInstance) {
        this.orgId = orgId;
        this.assetId = assetId;
        this.modelId = modelId;
        this.name = name;
        this.isDeviceInstance = isDeviceInstance;
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