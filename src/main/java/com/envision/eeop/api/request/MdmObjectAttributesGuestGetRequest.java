package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionSkipAndLimitRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by zhensheng.cai on 2017/9/1.
 */
public class MdmObjectAttributesGuestGetRequest  extends EnvisionSkipAndLimitRequest<MdmObjectAttributesGetResponse> {
    private static final String API_METHOD = "/mdmService/getObjectAttributes";
    private String guestIdAttr; //mandatory
    private String guestIds ; //mandatory
    private String attributeList;       // optional
    private String locale;              // optional

    public MdmObjectAttributesGuestGetRequest(String guestIdAttr , List<String> guestIds)
    {
        this.guestIdAttr = guestIdAttr;
        this.guestIds = StringUtils.listToString(guestIds, ',');
    }

    public MdmObjectAttributesGuestGetRequest(String guestIdAttr , List<String> guestIds, String locale)
    {
        this(guestIdAttr,guestIds);
        this.locale = locale;
    }

    public MdmObjectAttributesGuestGetRequest(String guestIdAttr , List<String> guestIds, List<String> attributeList)
    {
        this(guestIdAttr,guestIds);

        this.attributeList = StringUtils.listToString(attributeList, ',');
    }

    public MdmObjectAttributesGuestGetRequest(String guestIdAttr , List<String> guestIds, List<String> attributeList, String locale)
    {
        this(guestIdAttr,guestIds, attributeList);
        this.locale = locale;
    }

    public String getGuestIdAttr() {
        return guestIdAttr;
    }

    public void setGuestIdAttr(String guestIdAttr) {
        this.guestIdAttr = guestIdAttr;
    }

    public String getGuestIds() {
        return guestIds;
    }

    public void setGuestIds(String guestIds) {
        this.guestIds = guestIds;
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
        txtParams.put("guestidattr", this.guestIdAttr);
        txtParams.put("guestids", this.guestIds);
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
        RuleCheckUtils.checkNotEmpty(guestIdAttr, "guestidattr");
        RuleCheckUtils.checkNotEmpty(guestIds, "guestids");
    }
}
