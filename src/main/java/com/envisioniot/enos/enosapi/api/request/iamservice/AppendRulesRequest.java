package com.envisioniot.enos.enosapi.api.request.iamservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.Map;
import java.util.List;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class AppendRulesRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/iamService/policies/{policyId}/appendRules";
    private static final String REQUEST_METHOD = "PUT";
    @EnOSPathVariable(name = "policyId")
    private long policyId;
    @EnOSRequestBody
    private Map<String, List<String>> resourceActions;
    
    private String orgId;

    public AppendRulesRequest(long policyId, Map<String, List<String>> resourceActions, String orgId) {
        this.policyId = policyId;
        this.resourceActions = resourceActions;
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