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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((innerVer == null) ? 0 : innerVer.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((projectUid == null) ? 0 : projectUid.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!super.equals(obj)) return false;
        if(getClass() != obj.getClass()) return false;
        MdmObjectConfigSpec other = (MdmObjectConfigSpec) obj;
        if(innerVer == null)
        {
            if(other.innerVer != null) return false;
        }
        else if(!innerVer.equals(other.innerVer)) return false;
        if(model == null)
        {
            if(other.model != null) return false;
        }
        else if(!model.equals(other.model)) return false;
        if(projectUid == null)
        {
            if(other.projectUid != null) return false;
        }
        else if(!projectUid.equals(other.projectUid)) return false;
        if(type == null)
        {
            if(other.type != null) return false;
        }
        else if(!type.equals(other.type)) return false;
        if(uid == null)
        {
            if(other.uid != null) return false;
        }
        else if(!uid.equals(other.uid)) return false;
        return true;
    }
}
