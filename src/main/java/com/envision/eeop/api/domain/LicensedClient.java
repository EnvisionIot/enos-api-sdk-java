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

public class LicensedClient extends MdmObjectAttributes
{
    private static final long serialVersionUID = -2603858817586818898L;

    @SerializedName("siteid")
    private String siteID;

    public LicensedClient()
    {
        super();
    }
    
    public LicensedClient(String siteID, Map<String,String> attributes)
    {
        super(attributes);
        this.siteID = siteID;
    }

    public String getSiteID()
    {
        return siteID;
    }

    public void setSiteID(String siteID)
    {
        this.siteID = siteID;
    }

    @Override
    public String toString()
    {
        return "LicensedClient [siteID=" + siteID + ", attributes=" + attributes + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((siteID == null) ? 0 : siteID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!super.equals(obj)) return false;
        if(getClass() != obj.getClass()) return false;
        LicensedClient other = (LicensedClient) obj;
        if(siteID == null)
        {
            if(other.siteID != null) return false;
        }
        else if(!siteID.equals(other.siteID)) return false;
        return true;
    } 
}
