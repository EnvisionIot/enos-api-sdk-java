package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.LicensedClient;
import com.google.gson.annotations.SerializedName;

/**
 * Licensed Clients and associated site IDs
 * 
 * @author jieyuan.shen
 *
 */
public class LicensedClientsGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -8844203233448346211L;

    @SerializedName("data")
    private Map<String/*associate client SN*/,LicensedClient> licensedClients;

    public Map<String, LicensedClient> getLicensedClients()
    {
        return licensedClients;
    }

    public void setLicensedClients(Map<String, LicensedClient> licensedClients)
    {
        this.licensedClients = licensedClients;
    }

    @Override
    public String toString()
    {
        return "LicensedClientsGetResponse [licensedClients=" + licensedClients + "]";
    }
}
