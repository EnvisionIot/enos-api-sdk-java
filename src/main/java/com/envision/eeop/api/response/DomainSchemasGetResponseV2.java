package com.envision.eeop.api.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DomainInfo;
import com.envision.eeop.api.domain.DomainSchema;
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
            if (domainInfo.containsKey(entry.getValue()))
            {
                result.put(entry.getKey(), domainInfo.get(entry.getValue()));
            }
        }
        return result;
    }

    public Map<String, List<DomainSchema>> getDomainSchemas()
    {
        Map<String, List<DomainSchema>> result = new HashMap<>();
        for (Entry<String,String> entry: mdmToDomainInfo.entrySet())
        {
            if (domainInfo.containsKey(entry.getValue()))
            {
                result.put(entry.getKey(), domainInfo.get(entry.getValue()).getSchemas());
            }
        }
        return result;
    }

    public void setMdmToDomainInfo(Map<String,String> mdmToDomainInfo)
    {
        this.mdmToDomainInfo = mdmToDomainInfo;
    }

    public void setDomainInfo(Map<String,DomainInfo> domainInfo)
    {
        this.domainInfo = domainInfo;
    }
}
