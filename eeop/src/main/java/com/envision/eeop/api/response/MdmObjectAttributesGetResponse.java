/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.response;

import java.util.Collections;
import java.util.Map;

import com.envision.eeop.api.EnvisionSkipAndLimitResponse;
import com.envision.eeop.api.domain.MdmObjectAttributes;
import com.google.gson.annotations.SerializedName;

/**
 * MDM Object Attributes
 * 
 * @author jieyuan.shen
 */
public class MdmObjectAttributesGetResponse extends EnvisionSkipAndLimitResponse
{
    private static final long serialVersionUID = 5639495343976077137L;

    @SerializedName("data")
    private Map<String, MdmObjectAttributes> mdmObjects;

    public Map<String, MdmObjectAttributes> getMdmObjects()
    {
        return mdmObjects;
    }

    public void setMdmObjects(Map<String, MdmObjectAttributes> mdmObjects)
    {
        this.mdmObjects = mdmObjects;
    }

    @Override
    public EnvisionSkipAndLimitResponse merge(EnvisionSkipAndLimitResponse another)
    {
        if (another.isSuccess() && 
            another instanceof MdmObjectAttributesGetResponse)
        {
            mdmObjects.putAll(((MdmObjectAttributesGetResponse) another).mdmObjects);
        }
        return this;
    }

    @Override
    public String getLastElement()
    {
        if (!mdmObjects.isEmpty())
        {
            return Collections.max(mdmObjects.keySet());
        }
        else
        {
            return "";
        }
    }
}
