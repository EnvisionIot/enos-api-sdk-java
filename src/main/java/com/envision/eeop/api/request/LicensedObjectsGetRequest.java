/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.LicensedObjectsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class LicensedObjectsGetRequest implements EnvisionRequest<LicensedObjectsGetResponse>
{

    private static final String API_METHOD = "/mdmService/getLicensedObjects";

    private String licenseFingerprint;      // mandatory
    private String uidList;                 // mandatory
    private String attributeList;           // optional
    private String locale;                  // optional

    public LicensedObjectsGetRequest(String licenseFingerprint, List<String> uidList)
    {
        this.licenseFingerprint = licenseFingerprint;
        this.setUidList(StringUtils.listToString(uidList, ','));
    }

    public LicensedObjectsGetRequest(String licenseFingerprint, List<String> uidList, String locale)
    {
        this(licenseFingerprint, uidList);
        this.locale = locale;
    }

    public LicensedObjectsGetRequest(String licenseFingerprint, List<String> uidList, List<String> attributeList, String locale)
    {
        this(licenseFingerprint, uidList, locale);
        this.attributeList = StringUtils.listToString(attributeList, ',');
    }

    public String getLicenseFingerprint()
    {
        return licenseFingerprint;
    }

    public void setLicenseFingerprint(String licenseFingerprint)
    {
        this.licenseFingerprint = licenseFingerprint;
    }

    public String getUidList()
    {
        return uidList;
    }

    public void setUidList(String uidList)
    {
        this.uidList = uidList;
    }

    public String getAttributeList()
    {
        return attributeList;
    }

    public void setAttributeList(String attributeList)
    {
        this.attributeList = attributeList;
    }

    public String getLocale()
    {
        return locale;
    }

    public void setLocale(String locale)
    {
        this.locale = locale;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("licFp", licenseFingerprint);
        txtParams.put("uids", uidList);
        if(!StringUtils.isEmpty(attributeList))
        {
            txtParams.put("attributes", attributeList);
        }
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        return txtParams;
    }

    public Class<LicensedObjectsGetResponse> getResponseClass()
    {
        return LicensedObjectsGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(licenseFingerprint, "licFp");
        RuleCheckUtils.checkNotEmpty(uidList, "uids");
    }
}
