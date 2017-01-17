package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmObject;
import com.google.gson.annotations.SerializedName;

/**
 * MDM object insert response, including MDM ID and attributes
 * @author jieyuan.shen
 */
public class MdmObjectInsertResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 1061200529622421567L;

    @SerializedName("data")
    private MdmObject mdmObject;

    public MdmObject getMdmObject()
    {
        return mdmObject;
    }

    public void setMdmObject(MdmObject mdmObject)
    {
        this.mdmObject = mdmObject;
    }
}
