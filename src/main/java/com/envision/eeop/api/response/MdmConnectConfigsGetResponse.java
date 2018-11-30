package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmConnectConfigs;
import com.google.gson.annotations.SerializedName;

/**
 * Connect Config response
 * @author jieyuan.shen
 */
public class MdmConnectConfigsGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -4930139144885677168L;

    @SerializedName("data")
    private Map<String, MdmConnectConfigs> mdmToConnectConfig;

    public Map<String, MdmConnectConfigs> getMdmToConnectConfig()
    {
        return mdmToConnectConfig;
    }

    public void setMdmToConnectConfig(Map<String, MdmConnectConfigs> mdmToConnectConfig)
    {
        this.mdmToConnectConfig = mdmToConnectConfig;
    }

    @Override
    public String toString()
    {
        return "MdmConnectConfigsGetResponse [mdmToConnectConfig=" + mdmToConnectConfig + "]";
    }

}
