/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class EdgeUnregisterRequest implements EnvisionRequest<EnvisionResponse>
{

    private static final String API_METHOD = "/registerService/unregisterEdge";

    private String edgeID;              // mandatory

    public EdgeUnregisterRequest(String edgeID)
    {
        this.edgeID = edgeID;
    }

    public String getEdgeID()
    {
        return edgeID;
    }

    public void setEdgeID(String edgeID)
    {
        this.edgeID = edgeID;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("edgeid", edgeID);
        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(edgeID, "edgeid");
    }
}
