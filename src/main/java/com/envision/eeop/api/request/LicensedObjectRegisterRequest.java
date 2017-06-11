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

public class LicensedObjectRegisterRequest implements EnvisionRequest<EnvisionResponse>
{
    private static final String API_METHOD = "/mdmService/registerLicensedObject";

    private String licenseFingerprint;              // mandatory
    private String uid;                             // mandatory
    private String mdmID;                           // optional

    public LicensedObjectRegisterRequest(String licenseFingerprint, String uid, String mdmID)
    {
        this.licenseFingerprint = licenseFingerprint;
        this.uid = uid;
        this.mdmID = mdmID;
    }

    public String getLicenseFingerprint()
    {
        return licenseFingerprint;
    }

    public void setLicenseFingerprint(String licenseFingerprint)
    {
        this.licenseFingerprint = licenseFingerprint;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getMdmID()
    {
        return mdmID;
    }

    public void setMdmID(String mdmID)
    {
        this.mdmID = mdmID;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("licFp", licenseFingerprint);
        txtParams.put("uid", uid);
        txtParams.put("mdmid", mdmID);
        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(licenseFingerprint, "licFp");
        RuleCheckUtils.checkNotEmpty(uid, "uid");
    }
}
