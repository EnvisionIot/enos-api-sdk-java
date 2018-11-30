package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.Connection;
import com.google.gson.annotations.SerializedName;

/**
 * Connection detail response
 * @author jieyuan.shen
 */
public class ConnectionGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 228351668042172433L;

    @SerializedName("data")
    private Connection connection;

    public Connection getConnection()
    {
        return connection;
    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public String toString()
    {
        return "ConnectionGetResponse [connection=" + connection + ", status=" + status + ", msg=" + msg + ", submsg="
                + submsg + ", body=" + body + "]";
    }
}
