package com.envisioniot.enos.enosapi.api.request.dataservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import java.lang.Object;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetTsdbStoragePolicyMetaDataRequest extends EnOSRequest<EnOSResponse<List<Object>>> {
    private static final String API_METHOD = "/dataService/metaData/storage/tsdb/";
    private static final String REQUEST_METHOD = "GET";

    private String orgId;

    private String modelIds;

    private String measurepoints;

    public GetTsdbStoragePolicyMetaDataRequest(String orgId, String modelIds, String measurepoints) {
        this.orgId = orgId;
        this.modelIds = modelIds;
        this.measurepoints = measurepoints;
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