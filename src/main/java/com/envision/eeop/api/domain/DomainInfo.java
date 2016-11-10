package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.List;

public class DomainInfo implements Serializable
{
    private static final long serialVersionUID = 6781814600652725558L;
    
    private List<DomainSchema> schemas;
    private int domainID;
    private String domainName;
    
    public DomainInfo()
    {
        // nothing to be initialized
    }
    
    public DomainInfo(List<DomainSchema> schemas, int domainID, String domainName)
    {
        this.schemas = schemas;
        this.domainID = domainID;
        this.domainName = domainName;
    }

    public List<DomainSchema> getSchemas()
    {
        return schemas;
    }

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

    @Override
    public String toString()
    {
        return "DomainInfo [schemas=" + schemas + ", domainID=" + domainID + ", domainName=" + domainName + "]";
    }
}
