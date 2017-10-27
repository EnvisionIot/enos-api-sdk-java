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
    
    private String namespace;               // mandatory
    private int categoryID = 0;             // conditional
    private int typeID = 0;                 // optional
    private boolean includeGlobal = false;  // optional
    private String locale;                  // optional

    public DeviceTemplatesGetRequest(String namespace)
    {
    }
    
    public DeviceTemplatesGetRequest(String namespace, int categoryID)
    {
        this(namespace);
        this.categoryID = categoryID;
    }
    
    public DeviceTemplatesGetRequest(String namespace, int categoryID, int typeID)
    {
        this(namespace, categoryID);
        this.typeID = typeID;
    }
    
    public DeviceTemplatesGetRequest(String namespace, int categoryID, int typeID, String locale)
    {
        this(namespace, categoryID, typeID);
        this.locale = locale;
    }

    public String getNamespace()
    {
        return namespace;
    }

    public void setNamespace(String namespace)
    {
        this.namespace = namespace;
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
        txtParams.put("namespace", namespace);
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
        RuleCheckUtils.checkNotNull(namespace, "namespace is mandatory");
        RuleCheckUtils.checkArgument(typeID == 0 || categoryID != 0, "category is missing while type is provided");
    }
}
