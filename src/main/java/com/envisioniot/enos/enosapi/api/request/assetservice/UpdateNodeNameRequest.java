package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.assetservice.TSLStringI18n;
import java.lang.String;
import java.lang.Integer;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class UpdateNodeNameRequest extends EnOSRequest<EnOSResponse<Integer>> {
    private static final String API_METHOD = "/assetService/assetTrees/{assetTreeId}/nodes/{nodeId}";
    private static final String REQUEST_METHOD = "PUT";
    
    private String orgId;
    @EnOSPathVariable(name = "assetTreeId")
    private String assetTreeId;
    @EnOSPathVariable(name = "nodeId")
    private String nodeId;
    @EnOSRequestBody
    private TSLStringI18n name;

    public UpdateNodeNameRequest(String orgId, String assetTreeId, String nodeId, TSLStringI18n name) {
        this.orgId = orgId;
        this.assetTreeId = assetTreeId;
        this.nodeId = nodeId;
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