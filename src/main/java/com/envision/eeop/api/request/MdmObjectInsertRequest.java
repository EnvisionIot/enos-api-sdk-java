package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmObjectInsertResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;
import com.google.gson.reflect.TypeToken;

public class MdmObjectInsertRequest implements EnvisionRequest<MdmObjectInsertResponse>
{
    private static final String API_METHOD = "/mdmService/insertObject";

    private String parentID;                // mandatory
    private String category;                // conditional
    private String type;                    // mandatory
    private String attributes;              // optional
    private String mdmID;                   // optional
    private String locale;                  // optional

    /**
     * Request to insert a partner, customer, site group or site
     * @param parentID
     * @param type
     */
    public MdmObjectInsertRequest(String parentID, int typeID, Map<String,String> attributes)
    {
        this.parentID = parentID;
        this.type = String.valueOf(typeID);
        this.attributes = JsonParser.toJson(attributes);
    }
    
    /**
     * Request to insert a project or device
     * @param parentID
     * @param type
     */
    public MdmObjectInsertRequest(String parentID, int categoryID, int typeID, Map<String,String> attributes)
    {
        this(parentID, typeID, attributes);
        this.category = String.valueOf(categoryID);
    }
    
    /**
     * Request to insert a partner, customer, site group or site with specified MDM ID.
     * @param parentID
     * @param typeID
     * @param attributes
     * @param mdmID
     */
    public MdmObjectInsertRequest(String parentID, int typeID, Map<String,String> attributes, String mdmID)
    {
        this(parentID, typeID, attributes);
        this.mdmID = mdmID;
    }

    /**
     * Request to insert a project or device with specified MDM ID.
     * @param parentID
     * @param typeID
     * @param attributes
     * @param mdmID
     */
    public MdmObjectInsertRequest(String parentID, int category, int typeID, Map<String,String> attributes, String mdmID)
    {
        this(parentID, category, typeID, attributes);
        this.mdmID = mdmID;
    }

    public MdmObjectInsertRequest(String parentID, int typeID, Map<String,String> attributes, String mdmID, String locale)
    {
        this(parentID, typeID, attributes, mdmID);
        this.locale = locale;
    }

    public MdmObjectInsertRequest(String parentID, int category, int typeID, Map<String,String> attributes, String mdmID, String locale)
    {
        this(parentID, category, typeID, attributes, mdmID);
        this.locale = locale;
    }

    public String getParentID()
    {
        return parentID;
    }

    public void setParentID(String parentID)
    {
        this.parentID = parentID;
    }

    public int getCategory()
    {
        return Integer.parseInt(category);
    }

    public void setCategory(int category)
    {
        this.category = String.valueOf(category);
    }

    public int getType()
    {
        return Integer.parseInt(type);
    }

    public void setType(int type)
    {
        this.type = String.valueOf(type);
    }

    public Map<String,String> getAttributes()
    {
        return JsonParser.fromJson(attributes, new TypeToken<Map<String,String>>(){}.getType());
    }

    public void setAttributes(Map<String,String> attributes)
    {
        this.attributes = JsonParser.toJson(attributes);
    }

    public String getMdmID()
    {
        return mdmID;
    }

    public void setMdmID(String mdmID)
    {
        this.mdmID = mdmID;
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

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("parentid", parentID);
        if(!StringUtils.isEmpty(category))
        {
            txtParams.put("category", category);
        }
        txtParams.put("type", type);
        if(!StringUtils.isEmpty(attributes))
        {
            txtParams.put("attributes", attributes);
        }
        if(!StringUtils.isEmpty(mdmID))
        {
            txtParams.put("mdmid", mdmID);
        }
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        return txtParams;
    }

    public Class<MdmObjectInsertResponse> getResponseClass()
    {
        return MdmObjectInsertResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(parentID, "parentid");
        RuleCheckUtils.checkNotEmpty(type, "type");
        if (Integer.parseInt(type) >= 102)
        {
            RuleCheckUtils.checkNotEmpty(category, "category");
        }
    }
}