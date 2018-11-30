/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.Map;

import com.envision.eeop.api.util.JsonParser;
import com.google.gson.reflect.TypeToken;

public class MdmObjectAttributes implements Serializable
{

    private static final long serialVersionUID = 8325550459061696090L;

    protected Map<String, String> attributes;

    public MdmObjectAttributes()
    {
    }

    public MdmObjectAttributes(Map<String, String> attributes)
    {
        this.attributes = attributes;
    }

    public MdmObjectAttributes(String attributesJson)
    {
        attributes = JsonParser.fromJson(attributesJson, new TypeToken<Map<String, String>>()
        {
        }.getType());
    }

    public Map<String, String> getAttributes()
    {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes)
    {
        this.attributes = attributes;
    }

    @Override
    public String toString()
    {
        return "MdmObjectAttributes [attributes=" + attributes + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        MdmObjectAttributes other = (MdmObjectAttributes) obj;
        if(attributes == null)
        {
            if(other.attributes != null) return false;
        }
        else if(!attributes.equals(other.attributes)) return false;
        return true;
    }
}
