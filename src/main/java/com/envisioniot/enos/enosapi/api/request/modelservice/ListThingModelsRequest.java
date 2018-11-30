package com.envisioniot.enos.enosapi.api.request.modelservice;

import com.envisioniot.enos.enosapi.api.resource.modelservice.ThingModel;
import com.envisioniot.enos.enosapi.common.exception.EnOSRuleException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

public class ListThingModelsRequest extends EnOSRequest<EnOSResponse<EnOSPage<ThingModel>>> {
    private static final String API_METHOD = "/modelService/thingModels";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private int pageSize;
    
    private int pageToken;
    
    private String filter;

    public ListThingModelsRequest(String orgId, int pageSize, int pageToken, String filter) {
        this.orgId = orgId;
        this.pageSize = pageSize;
        this.pageToken = pageToken;
        this.filter = filter;
    }

    public ListThingModelsRequest(String orgId, int pageSize, int pageToken) {
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