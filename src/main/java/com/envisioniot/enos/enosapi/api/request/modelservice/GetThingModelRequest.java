package com.envisioniot.enos.enosapi.api.request.modelservice;

import com.envisioniot.enos.enosapi.api.resource.modelservice.ThingModel;
import com.envisioniot.enos.enosapi.common.annotation.EnOSPathVariable;
import com.envisioniot.enos.enosapi.common.exception.EnOSRuleException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

public class GetThingModelRequest extends EnOSRequest<EnOSResponse<ThingModel>> {
    private static final String API_METHOD = "/modelService/thingModels/{thingModelId}";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "thingModelId")
    private String thingModelId;

    public GetThingModelRequest(String orgId, String thingModelId) {
        this.orgId = orgId;
        this.thingModelId = thingModelId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getThingModelId() {
        return thingModelId;
    }

    public void setThingModelId(String thingModelId) {
        this.thingModelId = thingModelId;
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