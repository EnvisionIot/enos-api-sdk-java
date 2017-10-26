package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

public class AuthorizedNodeGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -5466908015271464893L;

    @SerializedName("data")
    private List<String> authNodes;

    public List<String> getAuthNodes()
    {
        return authNodes;
    }

    public void setAuthNodes(List<String> authNodes)
    {
        this.authNodes = authNodes;
    }

    @Override
    public String toString()
    {
        return "AuthorizedNodeGetResponse [authNodes=" + authNodes + "]";
    }
}
