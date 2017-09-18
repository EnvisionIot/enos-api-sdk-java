package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmObject;
import com.google.gson.annotations.SerializedName;

/**
 * Licensed Clients and associated site IDs
 * 
 * @author jieyuan.shen
 *
 */
public class LicensedObjectsGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -7797234791930317062L;

    @SerializedName("data")
    private Map<String/*associate UID*/,MdmObject> licensedObjects;

    public Map<String, MdmObject> getLicensedObjects()
    {
        return licensedObjects;
    }

    public void setLicensedObjects(Map<String, MdmObject> licensedObjects)
    {
        this.licensedObjects = licensedObjects;
    }

    @Override
    public String toString()
    {
        return "LicensedObjectsGetResponse [licensedObjects=" + licensedObjects + "]";
    }
}
