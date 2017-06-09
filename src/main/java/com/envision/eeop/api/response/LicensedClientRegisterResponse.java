package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Licensed Client and associated site ID
 * 
 * @author jieyuan.shen
 *
 */
public class LicensedClientRegisterResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -8198380572778591490L;

    private String clientSN;
    @SerializedName("siteid")
    private String siteID;
    private Map<String,String> attributes;

    public String getClientSN()
    {
        return clientSN;
    }

    public void setClientSN(String clientSN)
    {
        this.clientSN = clientSN;
    }

    public String getSiteID()
    {
        return siteID;
    }

    public void setSiteID(String siteID)
    {
        this.siteID = siteID;
    }

    public Map<String, String> getAttributes()
    {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes)
    {
        this.attributes = attributes;
    }

    @Override
    public String toString()
    {
        return "LicensedClientRegisterResponse [clientSN=" + clientSN + ", siteID=" + siteID + ", attributes=" + attributes + "]";
    }
}
