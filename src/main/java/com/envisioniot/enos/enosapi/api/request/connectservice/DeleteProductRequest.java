package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class DeleteProductRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/connectService/products/{productKey}";
    private static final String REQUEST_METHOD = "DELETE";
    
    private String orgId;
    @EnOSPathVariable(name = "productKey")
    private String productKey;

    public DeleteProductRequest(String orgId, String productKey) {
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