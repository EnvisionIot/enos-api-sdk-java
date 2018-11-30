package com.envisioniot.enos.enosapi.api.request.assetservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import com.envisioniot.enos.enosapi.api.resource.assetservice.Tree;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListTreesRequest extends EnOSRequest<EnOSResponse<List<Tree>>> {
    private static final String API_METHOD = "/assetService/assetTrees";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;

    public ListTreesRequest(String orgId) {
        this.orgId = orgId;
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