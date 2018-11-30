package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.util.List;
import com.envisioniot.enos.enosapi.api.resource.connectservice.DeviceCertSummaryInfo;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class ListCertificatesByAssetIdRequest extends EnOSRequest<EnOSResponse<List<DeviceCertSummaryInfo>>> {
    private static final String API_METHOD = "/connectService/devices/{assetId}/certificates/list";
    private static final String REQUEST_METHOD = "GET";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;

    public ListCertificatesByAssetIdRequest(String orgId, String assetId) {
        this.orgId = orgId;
        this.assetId = assetId;
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