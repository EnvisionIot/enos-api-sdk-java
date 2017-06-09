package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Licensed Client and associated site ID
 * 
 * @author jieyuan.shen
 *
 */
public class LicensedObjectRegisterResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -8198380572778591490L;

    private String uid;
    @SerializedName("mdmid")
    private String mdmID;
    private Map<String,String> attributes;

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getMdmID()
    {
        return mdmID;
    }

    public void setMdmID(String mdmID)
    {
        this.mdmID = mdmID;
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
        return "LicensedObjectRegisterResponse [uid=" + uid + ", mdmID=" + mdmID + ", attributes=" + attributes + "]";
    }
}
