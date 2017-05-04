/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MdmObjectAttributesSetRequest implements EnvisionRequest<EnvisionResponse>
{
    private static final String API_METHOD = "/mdmService/setObjectAttributes";

    private String mdmID;               // mandatory
    @SuppressWarnings("unused")
    @Deprecated
    private String attributeList;       // deprecated
    private Map<String,String> attributeJson = new HashMap<>();         // mandatory
    private String locale;              // optional
    private String defaultLocale;       // optional
    
    public MdmObjectAttributesSetRequest(String mdmID, Map<String, String> attributeValues)
    {
        this.mdmID = mdmID;
        this.attributeJson.putAll(attributeValues);
    }

    public MdmObjectAttributesSetRequest(String mdmID, Map<String, String> attributeValues, 
            String locale, boolean defaultLocale)
    {
        this(mdmID, attributeValues);
        this.locale = locale;
        this.defaultLocale = String.valueOf(defaultLocale);
    }

    public String getMdmID()
    {
        return mdmID;
    }

    public void setMdmID(String mdmID)
    {
        this.mdmID = mdmID;
    }

    public Map<String, String> getAttributeJson()
    {
        return attributeJson;
    }

    public void setAttributeJson(Map<String, String> attributeJson)
    {
        this.attributeJson = attributeJson;
    }

    /**
     * @deprecated use {@link #getAttributeJson()} instead
     */
    public String getAttributeList()
    {
        StringBuffer sb = new StringBuffer();
        Iterator<Entry<String,String>> it = attributeJson.entrySet().iterator();
        while (it.hasNext())
        {
            Entry<String,String> entry = it.next();
            sb.append(entry.getKey()).append(":\"")
              .append(entry.getValue())
              .append(it.hasNext() ? "\"," : "\"");
        }
        return sb.toString();
    }

    /**
     * @deprecated use {@link #setAttributeJson(Map)} instead
     */
    public void setAttributeList(String attributeList)
    {
        String[] attributeValues = StringUtils.split(
                attributeList.substring(0, attributeList.length() - 1), "\",");
        for (String attributeValue: attributeValues)
        {
            String[] keyValue = StringUtils.split(attributeValue, ":\"");
            this.attributeJson.put(keyValue[0], keyValue[1]);
        }
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmid", mdmID);
        txtParams.put("attributeValues", 
                new Gson().toJson(attributeJson, new TypeToken<Map<String,String>>(){}.getType()));
        // TODO: to be removed in future release
        txtParams.put("attributes", getAttributeList());
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        if (!StringUtils.isEmpty(defaultLocale))
        {
            txtParams.put("defaultLocale", defaultLocale);
        }

        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmID, "mdmid");
        RuleCheckUtils.checkNotEmpty(attributeJson, "attributeValues");
    }
}
