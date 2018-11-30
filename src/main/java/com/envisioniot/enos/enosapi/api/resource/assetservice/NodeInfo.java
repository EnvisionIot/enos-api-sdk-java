package com.envisioniot.enos.enosapi.api.resource.assetservice;

import java.io.Serializable;
import java.util.List;

public class NodeInfo implements Serializable
{
    private static final long serialVersionUID = -2499646490417617519L;
    private Node node;
    private List<Node> path;
    public Node getNode()
    {
        return node;
    }
    public void setNode(Node node)
    {
        this.node = node;
    }
    public List<Node> getPath()
    {
        return path;
    }
    public void setPath(List<Node> path)
    {
        this.path = path;
    }
    public NodeInfo()
    {
        super();
    }
    public NodeInfo(Node node, List<Node> path)
    {
        super();
        this.node = node;
        this.path = path;
    }
    @Override
    public String toString()
    {
        return "NodeInfo [node=" + node + ", path=" + path + "]";
    }

   
  
}
