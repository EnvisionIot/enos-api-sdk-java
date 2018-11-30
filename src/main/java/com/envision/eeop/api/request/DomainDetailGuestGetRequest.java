package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by zhensheng.cai on 2017/8/31.
 */
public class DomainDetailGuestGetRequest implements EnvisionRequest<DomainMetricsGetResponse> {
    private static final String API_METHOD = "/domainService/detailsV2";
    private String guestIdAttr;
    private String guestIds;

    private String metricList;

    private String beginTime;

    private String endTime;

    private Integer interval;

    private Integer limit;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public DomainDetailGuestGetRequest(String guestIdAttr,
                                       List<String> guestIdList,
                                       List<String> metrics,
                                       String beginTime) {
        this.guestIdAttr = guestIdAttr;
        this.guestIds = StringUtils.listToString(guestIdList,",");
        this.metricList = StringUtils.listToString(metrics, ',');
        this.beginTime = beginTime;
    }

    public DomainDetailGuestGetRequest(String guestIdAttr,
                                       List<String> guestIdList,
                                     List<String> metrics,
                                     String beginTime,
                                     String endTime) {
        this(guestIdAttr,guestIdList, metrics, beginTime);
        this.endTime = endTime;
    }

    public DomainDetailGuestGetRequest(String guestIdAttr,
                                       List<String> guestIdList,
                                     List<String> metrics,
                                     String beginTime,
                                     String endTime,
                                     Integer interval) {
        this(guestIdAttr,guestIdList, metrics, beginTime, endTime);
        this.interval = interval;
    }

    public DomainDetailGuestGetRequest(String guestIdAttr,
                                       List<String> guestIdList,
                                       List<String> metrics,
                                       String beginTime,
                                       String endTime,
                                       Integer interval,
                                       Integer limit) {
        this(guestIdAttr,guestIdList, metrics, beginTime, endTime, interval);
        this.limit = limit;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("guestidattr", guestIdAttr);
        txtParams.put("guestids", guestIds);
        txtParams.put("metrics", metricList);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        txtParams.put("interval", interval);
        txtParams.put("limit", limit);

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
