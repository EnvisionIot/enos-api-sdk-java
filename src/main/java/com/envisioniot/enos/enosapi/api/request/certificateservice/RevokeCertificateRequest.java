package com.envisioniot.enos.enosapi.api.request.certificateservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.api.resource.certificateservice.RequestCertificateResult;
import java.lang.String;
import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class RevokeCertificateRequest extends EnOSRequest<EnOSResponse<RequestCertificateResult>> {
    private static final String API_METHOD = "/certificateService/revokeCertificate";
    private static final String REQUEST_METHOD = "POST";

    private int issuedCertSN;

    public RevokeCertificateRequest(int issuedCertSN) {
        this.issuedCertSN = issuedCertSN;
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