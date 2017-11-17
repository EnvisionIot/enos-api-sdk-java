package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AttachedDeviceTemplatesGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

/**
 * This class implements a request for "mdmService/getAttachedDeviceTemplates"
 * @author shenjieyuan
 */
public class AttachedDeviceTemplatesGetRequest implements EnvisionRequest<AttachedDeviceTemplatesGetResponse>
{
    private static final String API_METHOD = "/mdmService/getAttachedDeviceTemplates";
    
    private String mdmIDList;               // mandatory
    private String locale;                  // optional

    public AttachedDeviceTemplatesGetRequest(List<String> mdmIDList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
    }
    
    public AttachedDeviceTemplatesGetRequest(List<String> mdmIDList, String locale)
    {
        this(mdmIDList);
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
        txtParams.put("mdmids", mdmIDList);
        if (!StringUtils.isEmpty(locale))
        {
            txtParams.put("locale", locale);
        }
        return txtParams;
    }

    @Override
    public Class<AttachedDeviceTemplatesGetResponse> getResponseClass()
    {
        return AttachedDeviceTemplatesGetResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
    }
}
