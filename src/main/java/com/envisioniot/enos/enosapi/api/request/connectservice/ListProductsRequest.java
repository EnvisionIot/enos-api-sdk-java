package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.api.resource.connectservice.Product;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListProductsRequest extends EnOSRequest<EnOSResponse<EnOSPage<Product>>> {
    private static final String API_METHOD = "/connectService/products";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private int pageSize;
    
    private int pageToken;

    public ListProductsRequest(String orgId, int pageSize, int pageToken) {
        this.orgId = orgId;
        this.pageSize = pageSize;
        this.pageToken = pageToken;
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