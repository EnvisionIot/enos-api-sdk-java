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

    private Integer scope;

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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageToken() {
        return pageToken;
    }

    public void setPageToken(int pageToken) {
        this.pageToken = pageToken;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
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