package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.Map;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListProductTagsRequest extends EnOSRequest<EnOSResponse<Map<String, String>>> {
    private static final String API_METHOD = "/connectService/product/{productKey}/tags";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;

    public ListProductTagsRequest(String orgId, String productKey) {
        this.orgId = orgId;
        this.productKey = productKey;
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