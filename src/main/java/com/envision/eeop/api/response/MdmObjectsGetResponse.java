package com.envision.eeop.api.response;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.envision.eeop.api.EnvisionSkipAndLimitResponse;
import com.envision.eeop.api.domain.MdmChildObjects;
import com.google.gson.annotations.SerializedName;

/**
 * MDM Child Objects grouped by parent and type
 * 
 * @author jieyuan.shen
 *
 */
public class MdmObjectsGetResponse extends EnvisionSkipAndLimitResponse
{
    private static final long serialVersionUID = -3251518557042008764L;

    @SerializedName("data")
    private Map<String/*associate mdmID*/,MdmChildObjects> mdmChildObjects;

    public Map<String, MdmChildObjects> getMdmChildObjects()
    {
        return mdmChildObjects;
    }

    public void setMdmChildObjects(Map<String, MdmChildObjects> mdmChildObjects)
    {
        this.mdmChildObjects = mdmChildObjects;
    }

    @Override
    public EnvisionSkipAndLimitResponse merge(EnvisionSkipAndLimitResponse another)
    {
        if (another.isSuccess() && 
            another instanceof MdmObjectsGetResponse)
        {
            for (Entry<String,MdmChildObjects> anotherEntry: 
                ((MdmObjectsGetResponse) another).mdmChildObjects.entrySet())
            {
                String mdmID = anotherEntry.getKey();
                MdmChildObjects anotherObjects = anotherEntry.getValue();
                if (mdmChildObjects.containsKey(mdmID))
                {
                    mdmChildObjects.put(mdmID, mdmChildObjects.get(mdmID).merge(anotherObjects));
                }
                else
                {
                    mdmChildObjects.put(mdmID, anotherObjects);
                }
            }
        }
        return this;
    }

    @Override
    public String getLastElement()
    {
        String mdmID = "";
        String associatedMdmID = "";
        if (!mdmChildObjects.isEmpty())
        {
            mdmID = Collections.max(mdmChildObjects.keySet());
        }
        
        if (!mdmID.isEmpty())
        {
            associatedMdmID = mdmChildObjects.get(mdmID).getLastElement();
        }
        
        return mdmID + "," + associatedMdmID;
    }
}
