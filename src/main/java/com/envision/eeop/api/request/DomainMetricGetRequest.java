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
public class DomainMetricGetRequest implements EnvisionRequest<DomainMetricsGetResponse> {
    private static final String API_METHOD = "/metricService/singleMetric";

    private String mdmIDList;

    private String metric;

    private String beginTime;

    private String endTime;

    private String timeGroup;

    private String sortType;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public DomainMetricGetRequest(List<String> mdmIds,
                                  String metric,
                                  String beginTime,
                                  String timeGroup) {
        this.mdmIDList = StringUtils.listToString(mdmIds, ',');
        this.metric = metric;
        this.beginTime = beginTime;
        this.timeGroup = timeGroup;
    }

    public DomainMetricGetRequest(List<String> mdmIds,
                                  String metric,
                                  String beginTime,
                                  String endTime,
                                  String timeGroup) {
        this(mdmIds, metric, beginTime, timeGroup);
        this.endTime = endTime;
    }

    public DomainMetricGetRequest(List<String> mdmIds,
                                  String metric,
                                  String beginTime,
                                  String endTime,
                                  String timeGroup,
                                  String sortType) {
        this(mdmIds, metric, beginTime, timeGroup);
        this.endTime = endTime;
        this.sortType = sortType;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmids", mdmIDList);
        txtParams.put("metric", metric);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        txtParams.put("time_group", timeGroup);
        txtParams.put("sort_type", sortType);

        return txtParams;
    }

    public Class<DomainMetricsGetResponse> getResponseClass() {
        return DomainMetricsGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metric, "metric");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkNotEmpty(timeGroup, "time_group");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }
}
