package com.envisioniot.enos.enosapi.api.resource.assetservice;

import java.io.Serializable;


public class Node implements Serializable
{
    private static final long serialVersionUID = -984453802727217426L;
    private String  id;
    private String  modelId;
    private String  instanceId;
    private TSLStringI18n name;
    private String  treeId;
    private Boolean isDeviceInstance;
    private Boolean hasChild;
    private BSLExtraInfo extraInfo;
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getModelId()
    {
        return modelId;
    }
    public void setModelId(String modelId)
    {
        this.modelId = modelId;
    }
    public String getInstanceId()
    {
        return instanceId;
    }
    public void setInstanceId(String instanceId)
    {
        this.instanceId = instanceId;
    }
    public TSLStringI18n getName()
    {
        return name;
    }
    public void setName(TSLStringI18n name)
    {
        this.name = name;
    }
    public String getTreeId()
    {
        return treeId;
    }
    public void setTreeId(String treeId)
    {
        this.treeId = treeId;
    }
    public Boolean getIsDeviceInstance()
    {
        return isDeviceInstance;
    }
    public void setIsDeviceInstance(Boolean isDeviceInstance)
    {
        this.isDeviceInstance = isDeviceInstance;
    }
    public Boolean getHasChild()
    {
        return hasChild;
    }
    public void setHasChild(Boolean hasChild)
    {
        this.hasChild = hasChild;
    }
    public BSLExtraInfo getExtraInfo()
    {
        return extraInfo;
    }
    public void setExtraInfo(BSLExtraInfo extraInfo)
    {
        this.extraInfo = extraInfo;
    }
    public Node()
    {
        super();
    }
    public Node(String id, String modelId, String instanceId, TSLStringI18n name,
            String treeId, Boolean isDeviceInstance, Boolean hasChild, BSLExtraInfo extraInfo)
    {
        super();
        this.id = id;
        this.modelId = modelId;
        this.instanceId = instanceId;
        this.name = name;
        this.treeId = treeId;
        this.isDeviceInstance = isDeviceInstance;
        this.hasChild = hasChild;
        this.extraInfo = extraInfo;
    }
    @Override
    public String toString()
    {
        return "Node [id=" + id + ", modelId=" + modelId + ", instanceId=" + instanceId
                + ", name=" + name + ", treeId=" + treeId + ", isDeviceInstance="
                + isDeviceInstance + ", hasChild=" + hasChild + ", extraInfo=" + extraInfo
                + "]";
    }
}
