package com.envisioniot.enos.enosapi.api.resource.assetservice;

import java.io.Serializable;

public class NodePath implements Serializable {
    private static final long serialVersionUID = -5357712130557547634L;

    private Node startNode;
    private Node endNode;
    
    // default constructor, don't delete it.
    public NodePath()
    {
    }
    
    public NodePath(Node startNode, Node endNode)
    {
        this.setStartNode(startNode);
        this.setEndNode(endNode);
    }

    public Node getStartNode()
    {
        return startNode;
    }

    public void setStartNode(Node startNode)
    {
        this.startNode = startNode;
    }

    public Node getEndNode()
    {
        return endNode;
    }

    public void setEndNode(Node endNode)
    {
        this.endNode = endNode;
    }

    @Override
    public String toString()
    {
        return "NodePath [startNode=" + startNode + ", endNode=" + endNode + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endNode == null) ? 0 : endNode.hashCode());
        result = prime * result + ((startNode == null) ? 0 : startNode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NodePath other = (NodePath) obj;
        if (endNode == null)
        {
            if (other.endNode != null) {
                return false;
            }
        } else if (!endNode.equals(other.endNode)) {
            return false;
        }
        if (startNode == null)
        {
            if (other.startNode != null) {
                return false;
            }
        } else if (!startNode.equals(other.startNode)) {
            return false;
        }
        return true;
    }
}
