package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.api.resource.connectservice.Product;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class CreateProductRequest extends EnOSRequest<EnOSResponse<Product>> {
    private static final String API_METHOD = "/connectService/products";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSRequestBody
    private Product product;

    public CreateProductRequest(String orgId, Product product) {
        this.orgId = orgId;
        this.product = product;
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