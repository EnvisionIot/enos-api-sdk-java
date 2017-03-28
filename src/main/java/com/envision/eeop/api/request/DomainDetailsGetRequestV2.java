package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainDetailsGetResponseV2;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;

import java.util.Map;

/**
 * DomainDetailGetRequest version 2
 * <p/>
 * Created by changyi.yuan on 2016/6/19.
 */
public class DomainDetailsGetRequestV2 implements EnvisionRequest<DomainDetailsGetResponseV2> {
    private static final String API_METHOD = "/domainService/detailsV2";

    private String mdmId;

    private String metric;

    private String beginTime;

    private String endTime;

    private String interval;

    private Integer limit;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public DomainDetailsGetRequestV2(String mdmId,
                                     String metric,
                                     String beginTime) {
        this(mdmId, metric, beginTime, null);
    }

    public DomainDetailsGetRequestV2(String mdmId,
                                     String metric,
                                     String beginTime,
                                     String endTime) {
        this(mdmId, metric, beginTime, endTime, null);
    }

    public DomainDetailsGetRequestV2(String mdmId,
                                     String metric,
                                     String beginTime,
                                     String endTime,
                                     String interval) {
        this(mdmId, metric, beginTime, endTime, interval, null);
    }

    public DomainDetailsGetRequestV2(String mdmIDList,
                                     String metricList,
                                     String beginTime,
                                     String endTime,
                                     String interval,
                                     Integer limit) {
        this.mdmId = mdmIDList;
        this.metric = metricList;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.interval = interval;
        this.limit = limit;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmid", mdmId);
        txtParams.put("metric", metric);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        txtParams.put("interval", interval);
        txtParams.put("limit", limit);

        return txtParams;
    }

    public Class<DomainDetailsGetResponseV2> getResponseClass() {
        return DomainDetailsGetResponseV2.class;
    }

    @Override
    public void check() throws EnvisionRuleException {

    }

}
