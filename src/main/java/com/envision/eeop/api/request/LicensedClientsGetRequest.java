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
import com.envision.eeop.api.response.LicensedClientsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class LicensedClientsGetRequest implements EnvisionRequest<LicensedClientsGetResponse>
{

    private static final String API_METHOD = "/mdmService/getLicensedClients";

    private String licenseFingerprint;      // mandatory
    private String clientSnList;            // mandatory
    private String attributeList;           // optional
    private String locale;                  // optional

    public LicensedClientsGetRequest(String licenseFingerprint, List<String> clientSnList)
    {
        this.licenseFingerprint = licenseFingerprint;
        this.clientSnList = StringUtils.listToString(clientSnList, ',');
    }

    public LicensedClientsGetRequest(String licenseFingerprint, List<String> clientSnList, String locale)
    {
        this(licenseFingerprint, clientSnList);
        this.locale = locale;
    }

    public LicensedClientsGetRequest(String licenseFingerprint, List<String> clientSnList, List<String> attributeList, String locale)
    {
        this(licenseFingerprint, clientSnList, locale);
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

    public String getClientSnList()
    {
        return clientSnList;
    }

    public void setClientSnList(String clientSnList)
    {
        this.clientSnList = clientSnList;
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
        txtParams.put("clientSns", clientSnList);
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

    public Class<LicensedClientsGetResponse> getResponseClass()
    {
        return LicensedClientsGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(licenseFingerprint, "licFp");
        RuleCheckUtils.checkNotEmpty(clientSnList, "clientSns");
    }
}
