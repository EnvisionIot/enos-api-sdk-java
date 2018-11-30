package com.envision.eeop.api.domain;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * This class describes an Edge
 * @author shenjieyuan
 */
public class Edge implements Serializable
{
    private static final long serialVersionUID = -9158342603318194946L;
    
    protected String name;
    @SerializedName("edgeSN")
    protected String sn;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEdgeSN()
    {
        return sn;
    }

    public void setEdgeSN(String edgeSN)
    {
        this.sn = edgeSN;
    }

    @Override
    public String toString()
    {
        return "Edge [name=" + name + ", sn=" + sn + "]";
    }
}
