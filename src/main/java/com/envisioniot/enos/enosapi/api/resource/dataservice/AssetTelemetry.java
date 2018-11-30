package com.envisioniot.enos.enosapi.api.resource.dataservice;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jingqi.shi on 2018/11/16
 */
public class AssetTelemetry implements Serializable {
    private static final long serialVersionUID = 8218144762693763393L;

    // assetId ~ devId
    private String assetId;

    // timestamp ~ ts
    private long timestamp;

    // other points. such [<windSpeed, v1>, <windDirection, v2>]
    private Map<String, Object> metrics;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Object> getMetrics() {
        return metrics;
    }

    public void setMetrics(Map<String, Object> metrics) {
        this.metrics = metrics;
    }

    @Override
    public String toString() {
        return "AssetTelemetry{" +
                "assetId='" + assetId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", metrics=" + metrics +
                '}';
    }
}
