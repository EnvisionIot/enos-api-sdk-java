package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DomainInfo implements Serializable
{
    private static final long serialVersionUID = 6781814600652725558L;
    
    private List<DomainSchema> schemas;
    private List<DomainSchema> passthroughPoints;
    private int domainID;
    private String domainName;
    
    public DomainInfo()
    {
        // nothing to be initialized
    }
    
    public DomainInfo(List<DomainSchema> schemas, List<DomainSchema> passthroughPoints, 
            int domainID, String domainName)
    {
        this.schemas = schemas;
        this.passthroughPoints = passthroughPoints;
        this.domainID = domainID;
        this.domainName = domainName;
    }

    public List<DomainSchema> getSchemas()
    {
        List<DomainSchema> allSchemas = new ArrayList<>(schemas.size() + passthroughPoints.size());
        allSchemas.addAll(schemas);
        allSchemas.addAll(passthroughPoints);
        return allSchemas;
    }
    
    public List<DomainSchema> getNonPassthroughSchemas()
    {
        return schemas;
    }
    
    public List<DomainSchema> getPassthroughPoints()
    {
        return passthroughPoints;
    }

    public void setNonPassthroughSchemas(List<DomainSchema> schemas)
    {
        this.schemas = schemas;
    }
    
    public void setPassthroughPoints(List<DomainSchema> passthroughPoints)
    {
        this.passthroughPoints = passthroughPoints;
    }

    /**
     * @deprecated With the introduction of passthrough points, the scope of schemas is 
     * enlarged. In the previous versions of this SDK, 'schemas' only means non-passthrough
     * schemas. use {@link #setNonPassthroughSchemas(List)} instead.
     * @param schemas non-passthrough schemas
     */
    public void setSchemas(List<DomainSchema> schemas)
    {
        this.schemas = schemas;
    }

    public int getDomainID()
    {
        return domainID;
    }

    public void setDomainID(int domainID)
    {
        this.domainID = domainID;
    }

    public String getDomainName()
    {
        return domainName;
    }

    public void setDomainName(String domainName)
    {
        this.domainName = domainName;
    }
}
