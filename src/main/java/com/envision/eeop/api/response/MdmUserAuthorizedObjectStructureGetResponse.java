package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionSkipAndLimitResponse;
import com.envision.eeop.api.domain.MdmObject;
import com.google.gson.annotations.SerializedName;

public class MdmUserAuthorizedObjectStructureGetResponse extends EnvisionSkipAndLimitResponse
{
    private static final long serialVersionUID = 943451741324250846L;

    @SerializedName("data")
    private List<MdmObject> mdmObjects;

    public List<MdmObject> getMdmObjects()
    {
        return mdmObjects;
    }

    public void setMdmObjects(List<MdmObject> mdmObjects)
    {
        this.mdmObjects = mdmObjects;
    }

    @Override
    public EnvisionSkipAndLimitResponse merge(EnvisionSkipAndLimitResponse another)
    {
        if (another.isSuccess() && 
            another instanceof MdmUserAuthorizedObjectStructureGetResponse)
        {
            mdmObjects.addAll(((MdmUserAuthorizedObjectStructureGetResponse) another).mdmObjects);
        }
        return this;
    }

    @Override
    public String getLastElement()
    {
        if (!mdmObjects.isEmpty())
        {
            return mdmObjects.get(mdmObjects.size() - 1).getMdmID();
        }
        else
        {
            return "";
        }
    }
}
