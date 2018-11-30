package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

/**
 * Response for client activation
 */
public class ClientActivateResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 7394419251870779384L;

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
        return "ClientActivateResponse [encryptedBoxInfo=" + encryptedBoxInfo + ", encryptedClientSecret=" + encryptedClientSecret + "]";
    }
}
