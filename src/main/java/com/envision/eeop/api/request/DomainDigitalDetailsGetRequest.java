package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DomainDigitalDetailsGetRequest implements EnvisionRequest<DomainMetricsGetResponse> {
    private static final String API_METHOD = "/domainService/digitalDetails";

    private String mdmIDList;

    private String metricList;

    private String beginTime;

    private String endTime;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public DomainDigitalDetailsGetRequest(List<String> mdmIds,
                                          List<String> metrics,
                                          String beginTime) {
        this.mdmIDList = StringUtils.listToString(mdmIds, ',');
        this.metricList = StringUtils.listToString(metrics, ',');
        this.beginTime = beginTime;
    }

    public DomainDigitalDetailsGetRequest(List<String> mdmIds,
                                          List<String> metrics,
                                          String beginTime,
                                          String endTime) {
        this(mdmIds, metrics, beginTime);
        this.endTime = endTime;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmids", mdmIDList);
        txtParams.put("metrics", metricList);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);

        return txtParams;
    }

    public Class<DomainMetricsGetResponse> getResponseClass() {
        return DomainMetricsGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }
}
