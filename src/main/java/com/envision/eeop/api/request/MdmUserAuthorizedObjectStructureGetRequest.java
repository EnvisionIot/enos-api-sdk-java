package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionSkipAndLimitRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmUserAuthorizedObjectStructureGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmUserAuthorizedObjectStructureGetRequest extends EnvisionSkipAndLimitRequest<MdmUserAuthorizedObjectStructureGetResponse>
{
    private static final String API_METHOD = "/mdmService/getUserAuthorizedObjectStructure";

    private String token; // mandatory
    
    private String userId; //mandatory

    private String type; // mandatory

    private String attributeList; // optional

    private String locale; // optional

    public MdmUserAuthorizedObjectStructureGetRequest(String token, String type, String userId)
    {
        super();
        this.token = token;
        this.type = type;
        this.userId = userId;
        // parentID, objectID and objectTypeID are mandatory attributes to describe structure
        this.attributeList = "";
    }

    public MdmUserAuthorizedObjectStructureGetRequest(String token, String type, String userId, String locale)
    {
        this(token, type, userId);
        this.locale = locale;
    }

    public MdmUserAuthorizedObjectStructureGetRequest(String token, String type, String userId, List<String> attributeList)
    {
        this(token, type, userId);
        this.attributeList = StringUtils.listToString(attributeList, ',');
    }

    public MdmUserAuthorizedObjectStructureGetRequest(String token, String type, String userId, List<String> attributeList, String locale)
    {
        this(token, type, userId, attributeList);
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

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
        txtParams.put("userId", userId);
        txtParams.put("attributes", attributeList);
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        txtParams.putAll(getPaginationParams());
        return txtParams;
    }

    public Class<MdmUserAuthorizedObjectStructureGetResponse> getResponseClass()
    {
        return MdmUserAuthorizedObjectStructureGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        super.check();
        RuleCheckUtils.checkNotEmpty(token, "token");
        RuleCheckUtils.checkNotEmpty(type, "type");
        RuleCheckUtils.checkNotEmpty(userId, "userId");
    }

}