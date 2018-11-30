package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.api.resource.assetservice.NodeInfo;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class SearchNodesRequest extends EnOSRequest<EnOSResponse<EnOSPage<NodeInfo>>> {
    private static final String API_METHOD = "/assetService/assetTrees/{assetTreeId}/nodes";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "assetTreeId")
    private String assetTreeId;
    
    private String searchKey;
    
    private String searchValue;
    
    private int pageToken;
    
    private int pageSize;

    public SearchNodesRequest(String orgId, String assetTreeId, String searchKey, String searchValue, int pageToken, int pageSize) {
        this.orgId = orgId;
        this.assetTreeId = assetTreeId;
        this.searchKey = searchKey;
        this.searchValue = searchValue;
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