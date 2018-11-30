package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmConnectConfigsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmConnectConfigsGetRequest implements EnvisionRequest<MdmConnectConfigsGetResponse>
{
    private static final String API_METHOD = "/connectService/getConnectConfigs";

    private String mdmIDList;   // mandatory

    public MdmConnectConfigsGetRequest(List<String> mdmIDList)
    {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
    }

    public String getMdmIDList()
    {
        return mdmIDList;
    }

    public void setMdmIDList(String mdmIDList)
    {
        this.mdmIDList = mdmIDList;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmids", mdmIDList);
        return txtParams;
    }

    public Class<MdmConnectConfigsGetResponse> getResponseClass()
    {
        return MdmConnectConfigsGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
    }

}
