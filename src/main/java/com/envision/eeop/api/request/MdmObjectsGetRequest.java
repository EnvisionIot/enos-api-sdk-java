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
import com.envision.eeop.api.response.MdmObjectsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmObjectsGetRequest 
extends EnvisionSkipAndLimitRequest<MdmObjectsGetResponse>
{
    private static final String API_METHOD = "/mdmService/getObjects";

    private String mdmIDList;           // mandatory
    private String typeList;            // optional
    private String attributeList;       // optional
    private String locale;              // optional

    public MdmObjectsGetRequest(List<String> mdmIDList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
    }

    public MdmObjectsGetRequest(List<String> mdmIDList, String locale)
    {
        this(mdmIDList);
        this.locale = locale;
    }

    public MdmObjectsGetRequest(List<String> mdmIDList, List<String> typeList, List<String> attributeList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
        this.typeList = StringUtils.listToString(typeList, ',');
        this.attributeList = StringUtils.listToString(attributeList, ',');
    }

    public MdmObjectsGetRequest(List<String> mdmIDList, List<String> typeList, List<String> attributeList, String locale)
    {
        this(mdmIDList, typeList, attributeList);
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

    public String getTypeList()
    {
        return typeList;
    }

    public void setTypeList(String typeList)
    {
        this.typeList = typeList;
    }

    public String getAttributeList()
    {
        return attributeList;
    }

    public void setAttributeList(String attributeList)
    {
        this.attributeList = attributeList;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmids", mdmIDList);
        if(!StringUtils.isEmpty(typeList))
        {
            txtParams.put("types", typeList);
        }
        if(!StringUtils.isEmpty(attributeList))
        {
            txtParams.put("attributes", attributeList);
        }
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        txtParams.putAll(getPaginationParams());

        return txtParams;
    }

    public Class<MdmObjectsGetResponse> getResponseClass()
    {
        return MdmObjectsGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        super.check();
        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
    }
}
