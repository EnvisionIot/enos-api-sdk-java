package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class DomainSchema implements Serializable
{
    private static final long serialVersionUID = -581311503263219261L;

    private String schema;
    private String schemaType;
    private String desc;
    private Map<String,String> metadata;
    private String valueType;
    private Boolean isArray;
    
    public static void main(String[] args)
    {
        DomainSchema schema = new DomainSchema();
        schema.schema = "foo";
        System.out.println(new Gson().toJson(schema));
        System.out.println(schema.isArray());
    }

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

    public String getSchemaType()
    {
        return schemaType;
    }

    public void setSchemaType(String schemaType)
    {
        this.schemaType = schemaType;
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

    public String getValueType()
    {
        return valueType;
    }

    public void setValueType(String valueType)
    {
        this.valueType = valueType;
    }

    public boolean isArray()
    {
        return isArray != null ? isArray : false;
    }

    public void setArray(boolean isArray)
    {
        this.isArray = isArray;
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
        return "DomainSchema [schema=" + schema + ", desc=" + desc + ", metadata=" + metadata + ", valueType="
                + valueType + ", isArray=" + isArray + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((desc == null) ? 0 : desc.hashCode());
        result = prime * result + ((isArray == null) ? 0 : isArray.hashCode());
        result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((schemaType == null) ? 0 : schemaType.hashCode());
        result = prime * result + ((valueType == null) ? 0 : valueType.hashCode());
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
        if (isArray == null)
        {
            if (other.isArray != null)
                return false;
        } else if (!isArray.equals(other.isArray))
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
        if (schemaType == null)
        {
            if (other.schemaType != null)
                return false;
        } else if (!schemaType.equals(other.schemaType))
            return false;
        if (valueType == null)
        {
            if (other.valueType != null)
                return false;
        } else if (!valueType.equals(other.valueType))
            return false;
        return true;
    }

}
