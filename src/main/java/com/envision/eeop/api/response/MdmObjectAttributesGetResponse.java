/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmObjectAttributes;
import com.google.gson.annotations.SerializedName;

/**
 * MDM Object Attributes
 * 
 * @author jieyuan.shen
 */
public class MdmObjectAttributesGetResponse extends EnvisionResponse
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
}
