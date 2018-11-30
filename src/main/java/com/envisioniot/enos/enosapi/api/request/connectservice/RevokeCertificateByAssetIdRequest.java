package com.envisioniot.enos.enosapi.api.request.connectservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class RevokeCertificateByAssetIdRequest extends EnOSRequest<EnOSResponse<String>> {
    private static final String API_METHOD = "/connectService/devices/{assetId}/certificates/revoke";
    private static final String REQUEST_METHOD = "DELETE";
    
    private String orgId;
    @EnOSPathVariable(name = "assetId")
    private String assetId;
    
    private String certSN;

    public RevokeCertificateByAssetIdRequest(String orgId, String assetId, String certSN) {
        this.orgId = orgId;
        this.assetId = assetId;
        this.certSN = certSN;
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