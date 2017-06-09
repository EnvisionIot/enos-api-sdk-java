/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class LicensedClientUnregisterRequest implements EnvisionRequest<EnvisionResponse>
{
    private static final String API_METHOD = "/mdmService/unregisterLicensedClient";

    private String licenseFingerprint;              // mandatory
    private String clientSN;                        // mandatory

    public LicensedClientUnregisterRequest(String licenseFingerprint, String clientSN)
    {
        this.licenseFingerprint = licenseFingerprint;
        this.clientSN = clientSN;
    }

    public String getLicenseFingerprint()
    {
        return licenseFingerprint;
    }

    public void setLicenseFingerprint(String licenseFingerprint)
    {
        this.licenseFingerprint = licenseFingerprint;
    }

    public String getClientSN()
    {
        return clientSN;
    }

    public void setClientSN(String clientSN)
    {
        this.clientSN = clientSN;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("licFp", licenseFingerprint);
        txtParams.put("clientSn", clientSN);
        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(licenseFingerprint, "licFp");
        RuleCheckUtils.checkNotEmpty(clientSN, "clientSn");
    }
}
