package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AlgoMetricsGetResponse;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class AlgoMetricsGetRequest implements EnvisionRequest<AlgoMetricsGetResponse> {
    private static final String API_METHOD = "/algoService/metrics";

    private String mdmIDList;

    private String metrics;

    private String beginTime;

    private String endTime;

    private String timeGroup;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public AlgoMetricsGetRequest(List<String> mdmIds,
                                 List<String> metrics,
                                 String beginTime,
                                 String timeGroup) {
        this.mdmIDList = StringUtils.listToString(mdmIds, ',');
        this.metrics = StringUtils.listToString(metrics, ',');
        this.beginTime = beginTime;
        this.timeGroup = timeGroup;
    }

    public AlgoMetricsGetRequest(List<String> mdmIds,
                                 List<String> metrics,
                                 String beginTime,
                                 String endTime,
                                 String timeGroup) {
        this(mdmIds, metrics, beginTime, timeGroup);
        this.endTime = endTime;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmids", mdmIDList);
        txtParams.put("metrics", metrics);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        txtParams.put("time_group", timeGroup);

        return txtParams;
    }

    public Class<AlgoMetricsGetResponse> getResponseClass() {
        return AlgoMetricsGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(domainPoints, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkNotEmpty(timeGroup, "time_group");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }
}
