package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EdgeStatusGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class EdgeStatusGetRequest implements EnvisionRequest<EdgeStatusGetResponse>
{
    private static final String API_METHOD = "/connectService/getEdgeStatus";

    private String edgeSN;   // mandatory

    public EdgeStatusGetRequest(String edgeSN)
    {
        this.edgeSN = edgeSN;
    }

    public String getEdgeSN()
    {
        return edgeSN;
    }

    public void setEdgeSN(String edgeSN)
    {
        this.edgeSN = edgeSN;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("edgeSN", edgeSN);
        return txtParams;
    }

    public Class<EdgeStatusGetResponse> getResponseClass()
    {
        return EdgeStatusGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(edgeSN, "edgeSN");
    }
}
