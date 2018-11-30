package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.Map;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class UpdateProductTagsRequest extends EnOSRequest<EnOSResponse<Map<String, String>>> {
    private static final String API_METHOD = "/connectService/product/{productKey}/tags";
    private static final String REQUEST_METHOD = "PUT";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;
    
    private boolean isOverwrite;
    @EnOSRequestBody
    private Map<String, String> tagMap;

    public UpdateProductTagsRequest(String orgId, String productKey, boolean isOverwrite, Map<String, String> tagMap) {
        this.orgId = orgId;
        this.productKey = productKey;
        this.isOverwrite = isOverwrite;
        this.tagMap = tagMap;
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