package com.envision.eeop.api.domain;

import java.io.Serializable;


public class ClientSecretInfo implements Serializable
{
    private static final long serialVersionUID = 2368630024167282491L;

    private String boxInfo;             // boxInfo encrypted by license public key
    private String clientSecret;        // client secret encrypted by license public key

    public String getBoxInfo()
    {
        return boxInfo;
    }

    public void setBoxInfo(String boxInfo)
    {
        this.boxInfo = boxInfo;
    }

    public String getClientSecret()
    {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret)
    {
        this.clientSecret = clientSecret;
    }

    @Override
    public String toString()
    {
        return "ClientSecretInfo [boxInfo=" + boxInfo + ", clientSecret=" + clientSecret + "]";
    }
}
