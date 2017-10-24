package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DeviceTemplate;
import com.google.gson.annotations.SerializedName;

/**
 * Response for getDeviceTemplates interface
 * @author shenjieyuan
 */
public class DeviceTemplatesGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -387455908032399682L;

    @SerializedName("data")
    private List<DeviceTemplate> deviceTemplates;

    public List<DeviceTemplate> getDeviceTemplates()
    {
        return deviceTemplates;
    }

    public void setDeviceTemplates(List<DeviceTemplate> deviceTemplates)
    {
        this.deviceTemplates = deviceTemplates;
    }

    @Override
    public String toString()
    {
        return "DeviceTemplatesGetResponse [deviceTemplates=" + deviceTemplates + "]";
    }
}
