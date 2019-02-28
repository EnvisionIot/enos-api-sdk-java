package com.envisioniot.enos.enosapi.api.resource.assetservice;

import java.io.Serializable;

public class NodeDeleteInfo implements Serializable
{
    private static final long serialVersionUID = -4183779311744815829L;

    private int num_nodeDeleted;
    private Boolean isLastNodeFromInstance;

    public int getNum_nodeDeleted()
    {
        return num_nodeDeleted;
    }

    public void setNum_nodeDeleted(int num_nodeDeleted)
    {
        this.num_nodeDeleted = num_nodeDeleted;
    }

    public Boolean getIsLastNodeFromInstance()
    {
        return isLastNodeFromInstance;
    }

    public void setIsLastNodeFromInstance(Boolean isLastNodeFromInstance)
    {
        this.isLastNodeFromInstance = isLastNodeFromInstance;
    }
    public NodeDeleteInfo() {
        super();
    }


    public NodeDeleteInfo(int num_nodeDeleted, Boolean isLastNodeFromInstance)
    {
        super();
        this.num_nodeDeleted = num_nodeDeleted;
        this.isLastNodeFromInstance = isLastNodeFromInstance;
    }

    @Override
    public String toString()
    {
        return "NodeDeleteInfo [num_nodeDeleted=" + num_nodeDeleted + ", isLastNodeFromInstance="
                + isLastNodeFromInstance + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isLastNodeFromInstance == null) ? 0 : isLastNodeFromInstance.hashCode());
        result = prime * result + num_nodeDeleted;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NodeDeleteInfo other = (NodeDeleteInfo) obj;
        if (isLastNodeFromInstance == null)
        {
            if (other.isLastNodeFromInstance != null)
                return false;
        } else if (!isLastNodeFromInstance.equals(other.isLastNodeFromInstance))
            return false;
        if (num_nodeDeleted != other.num_nodeDeleted)
            return false;
        return true;
    }
}
