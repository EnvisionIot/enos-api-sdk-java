package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * This class describes an EnOS connection
 * @author shenjieyuan
 */
public class Connection implements Serializable
{
    private static final long serialVersionUID = -9129515003862873836L;

    @SerializedName("connectionID")
    protected String id;
    protected String name;
    protected String type;      // connection type, can be TCP_SVR, UDP_CLT etc.
    protected boolean isKeepAlive;
    protected String address;
    @SerializedName("configuredDevices")
    protected List<String> mdmIDs;
    protected List<String> edgeSN;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public boolean isKeepAlive()
    {
        return isKeepAlive;
    }
    
    public void setKeepAlive(boolean isKeepAlive)
    {
        this.isKeepAlive = isKeepAlive;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }

    public List<String> getMdmIDs()
    {
        return mdmIDs;
    }

    public void setMdmIDs(List<String> mdmIDs)
    {
        this.mdmIDs = mdmIDs;
    }

    public List<String> getEdgeSN()
    {
        return edgeSN;
    }

    public void setEdgeSN(List<String> edgeSN)
    {
        this.edgeSN = edgeSN;
    }

    @Override
    public String toString()
    {
        return "Connection [id=" + id + ", name=" + name + ", type=" + type + ", isKeepAlive=" + isKeepAlive
                + ", address=" + address + ", mdmIDs=" + mdmIDs + ", edgeSN=" + edgeSN + "]";
    }
}
