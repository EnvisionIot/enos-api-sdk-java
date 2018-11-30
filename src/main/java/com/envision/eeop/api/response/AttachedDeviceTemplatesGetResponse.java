package com.envision.eeop.api.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DeviceTemplate;
import com.envision.eeop.api.util.StringUtils;
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

    /**
     * @deprecated use {@link #setMdmToDeviceTemplateIdList(Map)} instead, since multiple collects
     * may collect one device.
     * @param mdmToDeviceTemplateId
     */
    public void setMdmToDeviceTemplateId(Map<String, String> mdmToDeviceTemplateId)
    {
        this.mdmToDeviceTemplateId = mdmToDeviceTemplateId;
    }
    
    public void setMdmToDeviceTemplateIdList(Map<String,List<String>> mdmToDeviceTemplateIds)
    {
        mdmToDeviceTemplateId = new HashMap<>();
        for (Entry<String,List<String>> entry: mdmToDeviceTemplateIds.entrySet())
        {
            mdmToDeviceTemplateId.put(entry.getKey(), 
                    StringUtils.listToString(entry.getValue(), ','));
        }
        
    }

    public void setDeviceTemplates(Map<String, DeviceTemplate> deviceTemplates)
    {
        this.deviceTemplates = deviceTemplates;
    }
    
    public List<DeviceTemplate> getDeviceTemplateList(String mdmId)
    {
        List<DeviceTemplate> result = new ArrayList<>();

        if (mdmToDeviceTemplateId.containsKey(mdmId))
        {
            String[] deviceTemplateIds = StringUtils.split(mdmToDeviceTemplateId.get(mdmId), ",");
            for (String deviceTemplateId: deviceTemplateIds)
            {
                if (deviceTemplates.containsKey(deviceTemplateId))
                {
                    result.add(deviceTemplates.get(deviceTemplateId));
                }
            }
        }
        return result;
    }
    
    /**
     * @deprecated use {@link #getDeviceTemaplateList(String)} instead, since multiple collects may
     * collect one device, then multiple device templates can be found for one single device
     * @param mdmId
     * @return
     */
    public DeviceTemplate getDeviceTemplate(String mdmId)
    {
        List<DeviceTemplate> deviceTemplates = getDeviceTemplateList(mdmId);
        if (!deviceTemplates.isEmpty())
        {
            return deviceTemplates.iterator().next();
        }
        else
        {
            return null;
        }
    }

    /**
     * @deprecated use {@link #getDeviceTemplateLists()} instead, since multiple collects may
     * collect one device, then multiple device templates can be found for one single device
     * @return
     */
    public Map<String,DeviceTemplate> getDeviceTemplates()
    {
        Map<String,DeviceTemplate> result = new HashMap<>();
        for (String mdmId: mdmToDeviceTemplateId.keySet())
        {
            DeviceTemplate deviceTemplate = getDeviceTemplate(mdmId);
            if (deviceTemplate != null)
            {
                result.put(mdmId, deviceTemplate);
            }
        }
        return result;
    }
    
    
    public Map<String,List<DeviceTemplate>> getDeviceTemplateLists()
    {
        Map<String,List<DeviceTemplate>> result = new HashMap<>();
        for (String mdmId: mdmToDeviceTemplateId.keySet())
        {
            List<DeviceTemplate> deviceTemplates = getDeviceTemplateList(mdmId);
            if (!deviceTemplates.isEmpty())
            {
                result.put(mdmId, getDeviceTemplateList(mdmId));
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
