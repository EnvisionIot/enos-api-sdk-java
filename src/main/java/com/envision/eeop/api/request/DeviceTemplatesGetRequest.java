package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DeviceTemplatesGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class DeviceTemplatesGetRequest implements EnvisionRequest<DeviceTemplatesGetResponse>
{
    private static final String API_METHOD = "/modelService/getDeviceTemplates";
    
    private int categoryID = 0;             // conditional
    private int typeID = 0;                 // optional
    private boolean includeGlobal = false;  // optional
    private String locale;                  // optional

    public DeviceTemplatesGetRequest()
    {
    }
    
    public DeviceTemplatesGetRequest(int categoryID)
    {
        this.categoryID = categoryID;
    }
    
    public DeviceTemplatesGetRequest(int categoryID, int typeID)
    {
        this.categoryID = categoryID;
        this.typeID = typeID;
    }
    
    public DeviceTemplatesGetRequest(int categoryID, int typeID, String locale)
    {
        this(categoryID, typeID);
        this.locale = locale;
    }

    public int getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }

    public int getTypeID()
    {
        return typeID;
    }

    public void setTypeID(int typeID)
    {
        this.typeID = typeID;
    }

    public boolean isIncludeGlobal()
    {
        return includeGlobal;
    }

    public void setIncludeGlobal(boolean includeGlobal)
    {
        this.includeGlobal = includeGlobal;
    }

    public String getLocale()
    {
        return locale;
    }

    public void setLocale(String locale)
    {
        this.locale = locale;
    }

    @Override
    public String getApiMethodName()
    {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        if (categoryID != 0)
        {
            txtParams.put("category", String.valueOf(categoryID));
        }
        if (typeID != 0)
        {
            txtParams.put("type", String.valueOf(typeID));
        }
        if (includeGlobal)
        {
            txtParams.put("includeGlobal", "true");
        }
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        return txtParams;
    }

    @Override
    public Class<DeviceTemplatesGetResponse> getResponseClass()
    {
        return DeviceTemplatesGetResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkArgument(typeID == 0 || categoryID != 0, "category is missing while type is provided");
    }
}
