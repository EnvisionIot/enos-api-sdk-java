package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.assetservice.NodePath;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class SearchNodePathsRequest extends EnOSRequest<EnOSResponse<EnOSPage<NodePath>>> {
    private static final String API_METHOD = "/assetService/assetTrees/{assetTreeId}/nodePaths";
    private static final String REQUEST_METHOD = "GET";

    private String orgId;
    @EnOSPathVariable(name = "assetTreeId")
    private String assetTreeId;
    
    private String startNodeModelId;
    
    private String endNodeModelId;
    
    private int pageToken;
    
    private int pageSize;

    public SearchNodePathsRequest(String orgId, String assetTreeId, String startNodeModelId, String endNodeModelId, int pageToken, int pageSize) {
        this.orgId = orgId;
        this.assetTreeId = assetTreeId;
        this.startNodeModelId = startNodeModelId;
        this.endNodeModelId = endNodeModelId;
        this.pageToken = pageToken;
        this.pageSize = pageSize;
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