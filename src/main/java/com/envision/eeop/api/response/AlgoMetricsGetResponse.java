package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class AlgoMetricsGetResponse extends EnvisionResponse {
    private static final long serialVersionUID = 8127279315171206933L;

    @SerializedName("metrics")
    private List<Map<String, String>> metricList;

    public List<Map<String, String>> getMetricList() {
        return metricList;
    }

    public void setMetricList(List<Map<String, String>> metricList) {
        this.metricList = metricList;
    }
}
