package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.api.resource.connectservice.Device;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class CreateTopologyByAssetIdRequest extends EnOSRequest<EnOSResponse<List<Device>>> {
    private static final String API_METHOD = "/connectService/devices/{assetId}/topology/subDecices";
    private static final String REQUEST_METHOD = "POST";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;
    
    private String assetIds;

    public CreateTopologyByAssetIdRequest(String orgId, String assetId, String assetIds) {
        this.orgId = orgId;
        this.assetId = assetId;
        this.assetIds = assetIds;
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