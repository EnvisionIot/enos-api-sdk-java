package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainSchemasGetByIdResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.Map;

public class DomainSchemasGetByIdRequest implements EnvisionRequest<DomainSchemasGetByIdResponse>
{
    private static final String API_METHOD = "/modelService/getDomain";

    private int domainId;   // mandatory
    private String locale;  // optional

    public DomainSchemasGetByIdRequest(int domainId)
    {
        this.domainId = domainId;
    }

    public DomainSchemasGetByIdRequest(int domainId, String locale)
    {
        this.domainId = domainId;
        this.locale = locale;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
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
        txtParams.put("domainId", domainId + "");
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        return txtParams;
    }

    public Class<DomainSchemasGetByIdResponse> getResponseClass()
    {
        return DomainSchemasGetByIdResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
    }

}
