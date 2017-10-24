package com.envision.eeop.api.domain;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class DeviceTemplate implements Serializable
{
    private static final long serialVersionUID = -5634636117426401978L;
    
    @SerializedName("category")
    private int categoryID;
    @SerializedName("type")
    private int typeID;
    private String brand;
    private String model;
    private String innerVer;
    private String protocolType;
    private String protocolName;

    public int getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }

    public int getTypeID()
    {
        return typeID;
    }

    public void setTypeID(int typeID)
    {
        this.typeID = typeID;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
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

    public String getProtocolType()
    {
        return protocolType;
    }

    public void setProtocolType(String protocolType)
    {
        this.protocolType = protocolType;
    }

    public String getProtocolName()
    {
        return protocolName;
    }

    public void setProtocolName(String protocolName)
    {
        this.protocolName = protocolName;
    }

    @Override
    public String toString()
    {
        return "DeviceTemplate [categoryID=" + categoryID + ", typeID=" + typeID + ", brand=" + brand + ", model="
                + model + ", innerVer=" + innerVer + ", protocolType=" + protocolType + ", protocolName=" + protocolName
                + "]";
    }
}
