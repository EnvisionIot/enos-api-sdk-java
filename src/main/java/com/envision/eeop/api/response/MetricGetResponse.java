package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

import java.util.List;

/**
 * Created by changyi.yuan on 2016/6/17.
 */
public class MetricGetResponse extends EnvisionResponse {
    private static final long serialVersionUID = -3400168238802196047L;

    private List<Object> metrics;

    public List<Object> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Object> metrics) {
        this.metrics = metrics;
    }
}
