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
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.LicensedClientRegisterResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class LicensedClientRegisterRequest implements EnvisionRequest<LicensedClientRegisterResponse>
{

    private static final String API_METHOD = "/mdmService/registerLicensedClient";

    private String licenseFingerprint;              // mandatory
    private String clientSN;                        // mandatory
    private String siteID;                          // mandatory

    public LicensedClientRegisterRequest(String licenseFingerprint, String clientSN, String siteID)
    {
        this.licenseFingerprint = licenseFingerprint;
        this.clientSN = clientSN;
        this.siteID = siteID;
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

    public String getSiteID()
    {
        return siteID;
    }

    public void setSiteID(String siteID)
    {
        this.siteID = siteID;
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
        txtParams.put("siteid", siteID);
        return txtParams;
    }

    public Class<LicensedClientRegisterResponse> getResponseClass()
    {
        return LicensedClientRegisterResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(licenseFingerprint, "licFp");
        RuleCheckUtils.checkNotEmpty(clientSN, "clientSn");
        RuleCheckUtils.checkNotEmpty(siteID, "siteid");
    }
}
