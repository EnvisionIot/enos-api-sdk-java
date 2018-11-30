package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int size = (schemas != null ? schemas.size() : 0) + (passthroughPoints != null ? passthroughPoints.size() : 0);
        List<DomainSchema> allSchemas = new ArrayList<>(size);
        if (schemas != null) {
            allSchemas.addAll(schemas);
        }
        if (passthroughPoints != null) {
            allSchemas.addAll(passthroughPoints);
        }
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

    /**
     * This is based on the multiple collects collecting one device feature. <br>
     * domain ID and domain name shall be the same among all domain infos.
     * schemas and passthroughPoints shall be merged.
     * @param domainInfos
     * @return
     */
    public static DomainInfo merge(List<DomainInfo> domainInfos)
    {
        if (domainInfos == null || domainInfos.isEmpty())
        {
            return null;
        }
        DomainInfo result = new DomainInfo();
        result.domainID = domainInfos.iterator().next().domainID;
        result.domainName = domainInfos.iterator().next().domainName;

        // merge schemas and passthrough points.
        Set<DomainSchema> mergedSchemas = new HashSet<>();
        Set<DomainSchema> mergedPassthroughPoints = new HashSet<>();
        for (DomainInfo domainInfo: domainInfos)
        {
            mergedSchemas.addAll(domainInfo.schemas);
            mergedPassthroughPoints.addAll(domainInfo.passthroughPoints);
        }
        result.schemas = new ArrayList<DomainSchema>(mergedSchemas);
        result.passthroughPoints = new ArrayList<DomainSchema>(mergedPassthroughPoints);
        return result;
    }
}
