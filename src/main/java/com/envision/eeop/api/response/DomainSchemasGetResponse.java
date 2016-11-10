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
 * Domain schemas
 * @author jieyuan.shen
 */
public class DomainSchemasGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 5507674239653869373L;

    @SerializedName("data")
    private Map<String, DomainInfo> domainInfo;

    public Map<String, DomainInfo> getDomainInfo()
    {
        return domainInfo;
    }

    public void setDomainInfo(Map<String, DomainInfo> domainInfo)
    {
        this.domainInfo = domainInfo;
    }

    public Map<String, List<DomainSchema>> getDomainSchemas()
    {
        Map<String, List<DomainSchema>> result = new HashMap<>();
        for (Entry<String, DomainInfo> info: domainInfo.entrySet())
        {
            result.put(info.getKey(), info.getValue().getSchemas());
        }
        return result;
    }

    /**
     * @deprecated use {@link #setDomainInfo(Map)} instead
     */
    public void setDomainSchemas(Map<String, List<DomainSchema>> domainSchemas)
    {
        for (Entry<String, List<DomainSchema>> domainSchema: domainSchemas.entrySet())
        {
            if (domainInfo.containsKey(domainSchema.getKey()))
            {
                domainInfo.get(domainSchema.getKey()).setSchemas(domainSchema.getValue());
            }
        }
    }
}
