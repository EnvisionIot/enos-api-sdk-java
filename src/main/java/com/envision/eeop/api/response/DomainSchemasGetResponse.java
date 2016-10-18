package com.envision.eeop.api.response;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DomainSchema;
import com.google.gson.annotations.SerializedName;

/**
 * Domain schemas
 * 
 * @author jieyuan.shen
 */
public class DomainSchemasGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 5507674239653869373L;

    @SerializedName("data")
    private Map<String, List<DomainSchema>> domainSchemas;

    public Map<String, List<DomainSchema>> getDomainSchemas()
    {
        return domainSchemas;
    }

    public void setDomainSchemas(Map<String, List<DomainSchema>> domainSchemas)
    {
        this.domainSchemas = domainSchemas;
    }
}
