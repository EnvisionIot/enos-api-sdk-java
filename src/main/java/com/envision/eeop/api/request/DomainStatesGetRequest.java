package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainStatesGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DomainStatesGetRequest implements EnvisionRequest<DomainStatesGetResponse> {
    private static final String API_METHOD = "/domainService/states";

    private String mdmIDList;

    private String statesList;

    private String beginTime;

    private String endTime;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public DomainStatesGetRequest(List<String> mdmIds,
                                  List<String> states,
                                  String beginTime) {
        this.mdmIDList = StringUtils.listToString(mdmIds, ',');
        this.statesList = StringUtils.listToString(states, ',');
        this.beginTime = beginTime;
    }

    public DomainStatesGetRequest(List<String> mdmIds,
                                  List<String> states,
                                  String beginTime,
                                  String endTime) {
        this(mdmIds, states, beginTime);
        this.endTime = endTime;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmids", mdmIDList);
        txtParams.put("states", statesList);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);

        return txtParams;
    }

    public Class<DomainStatesGetResponse> getResponseClass() {
        return DomainStatesGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(statesList, "states");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }
}
