package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.ClientSecretInfo;
import com.google.gson.annotations.SerializedName;

/**
 * Response for client activation
 */
public class ClientActivateResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 7394419251870779384L;

    @SerializedName("data")
    private ClientSecretInfo clientSecretInfo;

    public ClientSecretInfo getClientSecretInfo()
    {
        return clientSecretInfo;
    }

    public void setClientSecretInfo(ClientSecretInfo clientSecretInfo)
    {
        this.clientSecretInfo = clientSecretInfo;
    }

    @Override
    public String toString()
    {
        return "ClientActivateResponse [clientSecretInfo=" + clientSecretInfo + "]";
    }
}
