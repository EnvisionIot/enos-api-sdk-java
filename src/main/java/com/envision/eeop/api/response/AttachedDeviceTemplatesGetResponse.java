package com.envision.eeop.api.response;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DeviceTemplate;
import com.google.gson.annotations.SerializedName;

/**
 * Response for getAttachedDeviceTemplates interface
 * @author shenjieyuan
 */
public class AttachedDeviceTemplatesGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 562209201885192770L;

    @SerializedName("data")
    private Map<String, String> mdmToDeviceTemplateId;

    private Map<String,DeviceTemplate> deviceTemplates;

    public void setMdmToDeviceTemplateId(Map<String, String> mdmToDeviceTemplateId)
    {
        this.mdmToDeviceTemplateId = mdmToDeviceTemplateId;
    }

    public void setDeviceTemplates(Map<String, DeviceTemplate> deviceTemplates)
    {
        this.deviceTemplates = deviceTemplates;
    }
    
    public DeviceTemplate getDeviceTemplate(String mdmId)
    {
        if (mdmToDeviceTemplateId.containsKey(mdmId))
        {
            String deviceTemplateId = mdmToDeviceTemplateId.get(mdmId);
            if (deviceTemplates.containsKey(deviceTemplateId))
            {
                return deviceTemplates.get(deviceTemplateId);
            }
        }
        return null;        // failed to find
    }

    public Map<String,DeviceTemplate> getDeviceTemplates()
    {
        Map<String,DeviceTemplate> result = new HashMap<>();
        for (Entry<String,String> entry: mdmToDeviceTemplateId.entrySet())
        {
            if (deviceTemplates.containsKey(entry.getValue()))
            {
                result.put(entry.getKey(), deviceTemplates.get(entry.getValue()));
            }
        }
        return result;
    }

    @Override
    public String toString()
    {
        return "AttachedDeviceTemplatesGetResponse [mdmToDeviceTemplateId=" + mdmToDeviceTemplateId
                + ", deviceTemplates=" + deviceTemplates + "]";
    }
}
