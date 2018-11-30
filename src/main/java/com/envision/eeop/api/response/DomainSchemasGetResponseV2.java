package com.envision.eeop.api.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DomainInfo;
import com.envision.eeop.api.domain.DomainSchema;
import com.envision.eeop.api.util.StringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * Domain schemas (TO BE USED IN FUTURE)
 * @author jieyuan.shen
 */
public class DomainSchemasGetResponseV2 extends EnvisionResponse
{
    private static final long serialVersionUID = 5507674239653869373L;

    @SerializedName("data")
    private Map<String, String> mdmToDomainInfo;

    private Map<String, DomainInfo> domainInfo;

    public Map<String, DomainInfo> getDomainInfo()
    {
        Map<String, DomainInfo> result = new HashMap<>();
        for (Entry<String,String> entry: mdmToDomainInfo.entrySet())
        {
            String[] domainInfoIDs = StringUtils.split(entry.getValue(), ",");
            List<DomainInfo> domainInfos = new ArrayList<>();
            for (String domainInfoID: domainInfoIDs)
            {
                if (domainInfo.containsKey(domainInfoID))
                {
                    domainInfos.add(domainInfo.get(domainInfoID));
                }
            }
            
            if (!domainInfos.isEmpty())
            {
                result.put(entry.getKey(), DomainInfo.merge(domainInfos));
            }
        }
        return result;
    }

    public Map<String, List<DomainSchema>> getDomainSchemas()
    {
        Map<String, List<DomainSchema>> result = new HashMap<>();
        Map<String,DomainInfo> domainInfoMap = getDomainInfo();
        for (Entry<String,DomainInfo> entry: domainInfoMap.entrySet())
        {
            result.put(entry.getKey(), entry.getValue().getSchemas());
        }
        return result;
    }

    /**
     * @param mdmToDomainInfo
     * @deprecated use {@link #setMdmToDomainInfoList(Map)} instead, since one device may be linked with 
     * multiple device templates now.
     */
    public void setMdmToDomainInfo(Map<String,String> mdmToDomainInfo)
    {
        this.mdmToDomainInfo = mdmToDomainInfo;
    }
    
    /**
     * Set a map between mdm id and domain info keys
     * @param mdmToDomainInfo
     */
    public void setMdmToDomainInfoList(Map<String,List<String>> mdmToDomainInfo)
    {
        this.mdmToDomainInfo = new HashMap<>();
        for (Entry<String,List<String>> entry: mdmToDomainInfo.entrySet())
        {
            String cimObjectID = entry.getKey();
            String domainInfoKey = StringUtils.listToString(entry.getValue(), ',');
            this.mdmToDomainInfo.put(cimObjectID, domainInfoKey);
        }
    }

    /**
     * Set a map listing domain infos.
     * @param domainInfo
     */
    public void setDomainInfo(Map<String,DomainInfo> domainInfo)
    {
        this.domainInfo = domainInfo;
    }
}
