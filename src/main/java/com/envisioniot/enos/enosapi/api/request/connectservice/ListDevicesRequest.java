package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.api.resource.connectservice.Device;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListDevicesRequest extends EnOSRequest<EnOSResponse<EnOSPage<Device>>> {
    private static final String API_METHOD = "/connectService/devices";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    
    private String productKey;
    
    private int pageSize;
    
    private int pageToken;

    public ListDevicesRequest(String orgId, String productKey, int pageSize, int pageToken) {
        this.orgId = orgId;
        this.productKey = productKey;
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