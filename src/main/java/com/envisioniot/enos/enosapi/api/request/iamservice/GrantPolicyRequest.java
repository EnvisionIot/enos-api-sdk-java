package com.envisioniot.enos.enosapi.api.request.iamservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GrantPolicyRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/iamService/policies/{policyId}/grant";
    private static final String REQUEST_METHOD = "PUT";
    @EnOSPathVariable(name = "policyId")
    private long policyId;
    
    private String subjectIds;
    
    private String orgId;

    public GrantPolicyRequest(long policyId, String subjectIds, String orgId) {
        this.policyId = policyId;
        this.subjectIds = subjectIds;
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