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
}
