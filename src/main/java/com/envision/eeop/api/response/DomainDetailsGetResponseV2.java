package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DomainDetailsGetResponseV2 extends EnvisionResponse {
    private static final long serialVersionUID = 8127279315171206933L;

    @SerializedName("metric")
    private String metric;

    @SerializedName("mdmid")
    private String mdmId;

    @SerializedName("details")
    private List<Map<String, String>> details;

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getMdmId() {
        return mdmId;
    }

    public void setMdmId(String mdmId) {
        this.mdmId = mdmId;
    }

    public List<Map<String, String>> getDetails() {
        return details;
    }

    public void setDetails(List<Map<String, String>> details) {
        this.details = details;
    }
}
