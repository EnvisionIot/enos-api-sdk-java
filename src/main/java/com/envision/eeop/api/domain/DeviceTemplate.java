package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class DeviceTemplate implements Serializable
{
    private static final long serialVersionUID = -5634636117426401978L;
    
    private int deviceTemplateID;
    @SerializedName("category")
    private int categoryID;
    @SerializedName("type")
    private int typeID;
    private String brand;
    private String model;
    private String innerVer;
    private String name;
    private String protocolType;
    private String protocolName;
    private int domainID;
    private Map<String, Integer> pointMap;

    public int getDeviceTemplateID()
    {
        return deviceTemplateID;
    }

    public void setDeviceTemplateID(int deviceTemplateID)
    {
        this.deviceTemplateID = deviceTemplateID;
    }

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public int getDomainID() {
        return domainID;
    }

    public void setDomainID(int domainID) {
        this.domainID = domainID;
    }

    public Map<String, Integer> getPointMap() {
        return pointMap;
    }

    public void setPointMap(Map<String, Integer> pointMap) {
        this.pointMap = pointMap;
    }

    @Override
    public String toString()
    {
        return "DeviceTemplate [deviceTemplateID=" + deviceTemplateID + ", categoryID=" + categoryID + ", typeID="
                + typeID + ", brand=" + brand + ", model=" + model + ", innerVer=" + innerVer + ", name=" + name
                + ", protocolType=" + protocolType + ", protocolName=" + protocolName + ", domainId=" + domainID + "]";
    }
}
