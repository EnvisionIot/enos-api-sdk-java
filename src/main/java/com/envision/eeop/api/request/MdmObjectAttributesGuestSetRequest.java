package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhensheng.cai on 2017/9/1.
 */
public class MdmObjectAttributesGuestSetRequest implements EnvisionRequest<EnvisionResponse> {
    private static final String API_METHOD = "/mdmService/setObjectAttributes";

    private String guestIdAttr;               // mandatory
    private String guestId;
    @SuppressWarnings("unused")
    @Deprecated
    private String attributeList;       // deprecated
    private Map<String,String> attributeJson = new HashMap<>();         // mandatory
    private String locale;              // optional
    private String defaultLocale;       // optional

    public MdmObjectAttributesGuestSetRequest(String guestIdAttr, String guestId, Map<String, String> attributeValues)
    {
        this.guestIdAttr= guestIdAttr;
        this.guestId= guestId;
        this.attributeJson.putAll(attributeValues);
    }

    public MdmObjectAttributesGuestSetRequest(String guestIdAttr, String guestId, Map<String, String> attributeValues,
                                              String locale, boolean defaultLocale)
    {
        this(guestIdAttr,guestId, attributeValues);
        this.locale = locale;
        this.defaultLocale = String.valueOf(defaultLocale);
    }

    public String getGuestIdAttr() {
        return guestIdAttr;
    }

    public void setGuestIdAttr(String guestIdAttr) {
        this.guestIdAttr = guestIdAttr;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
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
        Iterator<Map.Entry<String,String>> it = attributeJson.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String,String> entry = it.next();
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
        txtParams.put("guestidattr", guestIdAttr);
        txtParams.put("guestid", guestId);
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
        RuleCheckUtils.checkNotEmpty(guestId, "guestid");
        RuleCheckUtils.checkNotEmpty(guestIdAttr, "guestidattr");
        RuleCheckUtils.checkNotEmpty(attributeJson, "attributeValues");
    }
}
