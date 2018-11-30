package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class defines connect configuration, including
 *  - Edge
 *  - Connection
 * @author shenjieyuan
 */
public class MdmConnectConfigs implements Serializable
{
    private static final long serialVersionUID = 9084932397996128914L;
    
    protected List<Edge> edges;
    protected List<String> connectionIDs;

    /**
     * @deprecated use {@link #getEdges()} instead
     * @return
     */
    public Set<String> getEdgeSN()
    {
        Set<String> edgeSNs = new HashSet<>();
        for (Edge edge: edges)
        {
            edgeSNs.add(edge.sn);
        }
        return edgeSNs;
    }

    public List<Edge> getEdges()
    {
        return edges;
    }

    public void setEdges(List<Edge> edges)
    {
        this.edges = edges;
    }

    public List<String> getConnectionIDs()
    {
        return connectionIDs;
    }

    public void setConnectionIDs(List<String> connectionIDs)
    {
        this.connectionIDs = connectionIDs;
    }

    @Override
    public String toString()
    {
        return "MdmConnectConfigs [edges=" + edges + ", connectionIDs=" + connectionIDs + "]";
    }
}
