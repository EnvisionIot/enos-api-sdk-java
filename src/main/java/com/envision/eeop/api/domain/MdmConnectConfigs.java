package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * This class defines connect configuration, including
 *  - Edge
 * @author shenjieyuan
 */
public class MdmConnectConfigs implements Serializable
{
    private static final long serialVersionUID = 9084932397996128914L;
    
    protected Set<String> edgeSN = new HashSet<>();

    public MdmConnectConfigs()
    {
    }

    public MdmConnectConfigs(Collection<String> edgeSN)
    {
        this.edgeSN.addAll(edgeSN);
    }

    public Set<String> getEdgeSN()
    {
        return edgeSN;
    }

    public void setEdgeSN(Set<String> edgeSN)
    {
        this.edgeSN = edgeSN;
    }

    @Override
    public String toString()
    {
        return "MdmConnectConfigs [edgeSN=" + edgeSN + "]";
    }
}
