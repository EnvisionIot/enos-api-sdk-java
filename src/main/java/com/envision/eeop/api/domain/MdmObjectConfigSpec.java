/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import com.google.gson.annotations.SerializedName;

/**
 * This class defines the spec information of an object to be configured.
 * @author jieyuan.shen
 */
public class MdmObjectConfigSpec extends MdmObjectAttributes
{
    private static final long serialVersionUID = -9062886123601611705L;
    
    public static final String DEVICE_TYPE = "device";
    public static final String PROJECT_TYPE = "project";
    
    private String type;
    private String model;
    private String innerVer;
    @SerializedName("UID")
    private String uid;
    @SerializedName("projectUID")
    private String projectUid;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getInnerVer()
    {
        return innerVer;
    }

    public void setInnerVer(String innerVer)
    {
        this.innerVer = innerVer;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getProjectUid()
    {
        return projectUid;
    }

    public void setProjectUid(String projectUid)
    {
        this.projectUid = projectUid;
    }

    @Override
    public String toString()
    {
        return "MdmObjectConfigSpec [type=" + type + ", model=" + model + ", innerVer=" + innerVer + ", uid=" + uid + ", projectUid=" + projectUid + ", attributes=" + attributes + "]";
    }
}
