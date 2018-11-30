package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.api.resource.assetservice.NodeInfo;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetNodeRequest extends EnOSRequest<EnOSResponse<NodeInfo>> {
    private static final String API_METHOD = "/assetService/assetTrees/{assetTreeId}/nodes/{nodeId}";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "assetTreeId")
    private String assetTreeId;
    @EnOSPathVariable(name = "nodeId")
    private String nodeId;

    public GetNodeRequest(String orgId, String assetTreeId, String nodeId) {
        this.orgId = orgId;
        this.assetTreeId = assetTreeId;
        this.nodeId = nodeId;
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