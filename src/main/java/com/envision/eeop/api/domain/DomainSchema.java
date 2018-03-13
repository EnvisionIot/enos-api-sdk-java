package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DomainSchema implements Serializable
{
    private static final long serialVersionUID = -581311503263219261L;

    private String schema;
    private String desc;
    private Map<String,String> metadata;

    public DomainSchema()
    {
    }

    public DomainSchema(String schema)
    {
        this.schema = schema;
    }

    public String getSchema()
    {
        return schema;
    }

    public void setSchema(String schema)
    {
        this.schema = schema;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public Map<String, String> getMetadata()
    {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata)
    {
        this.metadata = metadata;
    }

    /**
     * @deprecated replaced by getSchema() and getDesc()
     */
    public Map<String, String> getSchemaDef()
    {
        Map<String,String> schemaDef = new HashMap<>();
        schemaDef.put("schema", schema);
        if (desc != null)
        {
            schemaDef.put("desc", desc);
        }
        return schemaDef;
    }

    @Override
    public String toString()
    {
        return "DomainSchema [schema=" + schema + ", desc=" + desc + ", metadata=" + metadata + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((desc == null) ? 0 : desc.hashCode());
        result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DomainSchema other = (DomainSchema) obj;
        if (desc == null)
        {
            if (other.desc != null)
                return false;
        } else if (!desc.equals(other.desc))
            return false;
        if (metadata == null)
        {
            if (other.metadata != null)
                return false;
        } else if (!metadata.equals(other.metadata))
            return false;
        if (schema == null)
        {
            if (other.schema != null)
                return false;
        } else if (!schema.equals(other.schema))
            return false;
        return true;
    }

}
