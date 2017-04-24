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
public class AlgoMetricsGetRequest implements EnvisionRequest<DomainMetricsGetResponse> {
    private static final String API_METHOD = "/algoService/domainPoints";

    private String mdmIDList;

    private String domainPoints;

    private String beginTime;

    private String endTime;

    private String timeGroup;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public AlgoMetricsGetRequest(List<String> mdmIds,
                                 List<String> domainPoints,
                                 String beginTime,
                                 String timeGroup) {
        this.mdmIDList = StringUtils.listToString(mdmIds, ',');
        this.domainPoints = StringUtils.listToString(domainPoints, ',');
        this.beginTime = beginTime;
        this.timeGroup = timeGroup;
    }

    public AlgoMetricsGetRequest(List<String> mdmIds,
                                 List<String> domainPoints,
                                 String beginTime,
                                 String endTime,
                                 String timeGroup) {
        this(mdmIds, domainPoints, beginTime, timeGroup);
        this.endTime = endTime;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmids", mdmIDList);
        txtParams.put("domainPoints", domainPoints);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        txtParams.put("time_group", timeGroup);

        return txtParams;
    }

    public Class<DomainMetricsGetResponse> getResponseClass() {
        return DomainMetricsGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(domainPoints, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkNotEmpty(timeGroup, "time_group");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }
}
