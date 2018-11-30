package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Edge status response
 * @author jieyuan.shen
 */
public class EdgeStatusGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 8393008166242695281L;
    
    // edge conn
    public static String EDGE_CONN = "EDGE_CONN";
    public static String EDGE_DISCONNECTED = "0";
    public static String EDGE_CONNECTED = "1";

    @SerializedName("data")
    private Map<String, String> edgeStatus;

    public Map<String, String> getEdgeStatus()
    {
        return edgeStatus;
    }

    public void setEdgeStatus(Map<String, String> edgeStatus)
    {
        this.edgeStatus = edgeStatus;
    }

    public boolean isEdgeConnected()
    {
        return edgeStatus.containsKey(EDGE_CONN) && 
               edgeStatus.get(EDGE_CONN).equals(EDGE_CONNECTED);
    }

    @Override
    public String toString()
    {
        return "EdgeStatusGetResponse [edgeStatus=" + edgeStatus + "]";
    }
}
