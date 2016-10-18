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
     * @deprecated replaced by setDesc()
     */
    public void includeDescription(String desc)
    {
        this.desc = desc;
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

    /**
     * @deprecated replaced by setSchema() and setDesc()
     */
    public void setSchemaDef(Map<String, String> schemaDef)
    {
        if (schemaDef.containsKey("schema"))
        {
            schema = schemaDef.get("schema");
        }
        if (schemaDef.containsKey("desc"))
        {
            desc = schemaDef.get("desc");
        }
    }

    @Override
    public String toString()
    {
        return "DomainSchema [schema=" + schema + ", desc=" + desc + ", metadata=" + metadata + "]";
    }
}
