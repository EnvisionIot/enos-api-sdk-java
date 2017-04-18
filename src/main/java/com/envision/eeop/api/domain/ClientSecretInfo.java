package com.envision.eeop.api.domain;

import java.io.Serializable;


public class ClientSecretInfo implements Serializable
{
    private static final long serialVersionUID = 2368630024167282491L;

    private String encryptedBoxInfo;             // boxInfo encrypted by license public key
    private String encryptedClientSecret;        // client secret encrypted by license public key

    public String getEncryptedBoxInfo()
    {
        return encryptedBoxInfo;
    }

    public void setEncryptedBoxInfo(String encryptedBoxInfo)
    {
        this.encryptedBoxInfo = encryptedBoxInfo;
    }

    public String getEncryptedClientSecret()
    {
        return encryptedClientSecret;
    }

    public void setEncryptedClientSecret(String encryptedClientSecret)
    {
        this.encryptedClientSecret = encryptedClientSecret;
    }

    @Override
    public String toString()
    {
        return "ClientSecretInfo [encryptedBoxInfo=" + encryptedBoxInfo + ", encryptedClientSecret=" + encryptedClientSecret + "]";
    }
}
