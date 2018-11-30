package com.envisioniot.enos.enosapi.api.resource.assetservice;

import java.io.Serializable;

public class Tree implements Serializable
{
    private static final long serialVersionUID = 5982651764896784302L;
    private String id;
    private String rootNodeId;
    private String createBy;
    private String createTime;
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getRootNodeId()
    {
        return rootNodeId;
    }
    public void setRootNodeId(String rootNodeId)
    {
        this.rootNodeId = rootNodeId;
    }
    public String getCreateBy()
    {
        return createBy;
    }
    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }
    public String getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    public Tree()
    {
        super();
    }
    public Tree(String id, String rootNodeId, String createBy, String createTime)
    {
        super();
        this.id = id;
        this.rootNodeId = rootNodeId;
        this.createBy = createBy;
        this.createTime = createTime;
    }
    @Override
    public String toString()
    {
        return "Tree [id=" + id + ", rootNodeId=" + rootNodeId + ", createBy=" + createBy
                + ", createTime=" + createTime + "]";
    }
    

}
