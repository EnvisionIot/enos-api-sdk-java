package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionSkipAndLimitRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmObjectStructureGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmObjectStructureGetRequest extends EnvisionSkipAndLimitRequest<MdmObjectStructureGetResponse>
{
    private static final String API_METHOD = "/mdmService/getObjectStructure";

    private String token; // mandatory

    private String type; // mandatory

    private String attributeList; // optional

    private String locale; // optional

    public MdmObjectStructureGetRequest(String token, String type)
    {
        super();
        this.token = token;
        this.type = type;
        // parentID, objectID and objectTypeID are mandatory attributes to describe structure
        this.attributeList = "";
    }

    public MdmObjectStructureGetRequest(String token, String type, String locale)
    {
        this(token, type);
        this.locale = locale;
    }

    public MdmObjectStructureGetRequest(String token, String type, List<String> attributeList)
    {
        this(token, type);
        this.attributeList = StringUtils.listToString(attributeList, ',');
    }

    public MdmObjectStructureGetRequest(String token, String type, List<String> attributeList, String locale)
    {
        this(token, type, attributeList);
        this.locale = locale;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
        txtParams.put("token", token);
        txtParams.put("type", type);
        txtParams.put("attributes", attributeList);
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        txtParams.putAll(getPaginationParams());
        return txtParams;
    }

    public Class<MdmObjectStructureGetResponse> getResponseClass()
    {
        return MdmObjectStructureGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        super.check();
        RuleCheckUtils.checkNotEmpty(token, "token");
        RuleCheckUtils.checkNotEmpty(type, "type");
    }

}