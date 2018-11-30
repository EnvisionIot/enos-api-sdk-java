package com.envisioniot.enos.enosapi.api.request.iamservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.iamservice.Policy;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class CreatePolicyRequest extends EnOSRequest<EnOSResponse<Policy>> {
    private static final String API_METHOD = "/iamService/policies";
    private static final String REQUEST_METHOD = "POST";
    @EnOSRequestBody
    private Policy policy;
    
    private String orgId;

    public CreatePolicyRequest(Policy policy, String orgId) {
        this.policy = policy;
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