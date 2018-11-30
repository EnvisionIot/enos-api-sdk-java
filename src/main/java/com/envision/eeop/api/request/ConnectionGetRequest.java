package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.ConnectionGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class ConnectionGetRequest implements EnvisionRequest<ConnectionGetResponse>
{
    private static final String API_METHOD = "/connectService/getConnection";

    private String connectionID;   // mandatory

    public ConnectionGetRequest(String connectionID)
    {
        this.connectionID = connectionID;
    }

    public String getConnectionID()
    {
        return connectionID;
    }

    public void setConnectionID(String connectionID)
    {
        this.connectionID = connectionID;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("connectionID", connectionID);
        return txtParams;
    }

    public Class<ConnectionGetResponse> getResponseClass()
    {
        return ConnectionGetResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(connectionID, "connectionID");
    }

    @Override
    public String toString()
    {
        return "ConnectionGetRequest [connectionID=" + connectionID + "]";
    }
}
