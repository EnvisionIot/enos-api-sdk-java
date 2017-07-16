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

import com.envision.eeop.api.EnvisionSkipAndLimitRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmObjectAttributesGetRequest 
extends EnvisionSkipAndLimitRequest<MdmObjectAttributesGetResponse>
{
    private static final String API_METHOD = "/mdmService/getObjectAttributes";

    private String mdmIDList;           // mandatory
    private String attributeList;       // optional
    private String locale;              // optional

    public MdmObjectAttributesGetRequest(List<String> mdmIDList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
    }

    public MdmObjectAttributesGetRequest(List<String> mdmIDList, String locale)
    {
        this(mdmIDList);
        this.locale = locale;
    }

    public MdmObjectAttributesGetRequest(List<String> mdmIDList, List<String> attributeList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
        this.attributeList = StringUtils.listToString(attributeList, ',');
    }

    public MdmObjectAttributesGetRequest(List<String> mdmIDList, List<String> attributeList, String locale)
    {
        this(mdmIDList, attributeList);
        this.locale = locale;
    }

    public String getMdmIDList()
    {
        return mdmIDList;
    }

    public void setMdmIDList(String mdmIDList)
    {
        this.mdmIDList = mdmIDList;
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
        txtParams.put("mdmids", this.mdmIDList);
        if (!StringUtils.isEmpty(attributeList))
        {
            txtParams.put("attributes", this.attributeList);
        }
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        txtParams.putAll(getPaginationParams());

        return txtParams;
    }

    public Class<MdmObjectAttributesGetResponse> getResponseClass()
    {
        return MdmObjectAttributesGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        super.check();
        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
    }
}
