/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class MdmObject extends MdmObjectAttributes
implements Comparable<MdmObject>
{
    private static final long serialVersionUID = -4914612001721892494L;

    @SerializedName("mdmid")
    private String mdmID;

    public MdmObject()
    {
        super();
    }

    public MdmObject(String mdmID, Map<String, String> attributes)
    {
        super(attributes);
        this.mdmID = mdmID;
    }

    public MdmObject(String mdmID, String attributesJson)
    {
        super(attributesJson);
        this.mdmID = mdmID;
    }

    public String getMdmID()
    {
        return mdmID;
    }

    @Override
    public String toString()
    {
        return "MdmObject [mdmID=" + mdmID + ", attributes=" + attributes + "]";
    }

    @Override
    public int compareTo(MdmObject o)
    {
        return mdmID.compareTo(o.mdmID);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((mdmID == null) ? 0 : mdmID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!super.equals(obj)) return false;
        if(getClass() != obj.getClass()) return false;
        MdmObject other = (MdmObject) obj;
        if(mdmID == null)
        {
            if(other.mdmID != null) return false;
        }
        else if(!mdmID.equals(other.mdmID)) return false;
        return true;
    }
}
