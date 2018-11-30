package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.SampleDataGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class SampleDataGetRequest implements EnvisionRequest<SampleDataGetResponse> {
    private static final String API_METHOD = "/asset_data/sample_data";

    private String assetIds;

    private String table;

    private Long beginTime;

    private Long endTime;

    private String columns;

    private String valueFilters;

    private Integer interval;

    private Integer limit;

    private String offset;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public SampleDataGetRequest(List<String> assetIds,
                                String table,
                                List<String> columns,
                                long beginTime) {
        this.assetIds = StringUtils.listToString(assetIds, ',');
        this.table = table;
        this.columns = StringUtils.listToString(columns, ',');
        this.beginTime = beginTime;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("asset_ids", assetIds);
        txtParams.put("table", table);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        txtParams.put("columns", columns);
        txtParams.put("value_filters", valueFilters);
        txtParams.put("interval", interval);
        txtParams.put("limit", limit);
        txtParams.put("offset", offset);

        return txtParams;
    }

    @Override
    public Class<SampleDataGetResponse> getResponseClass() {
        return SampleDataGetResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setValueFilters(String valueFilters) {
        this.valueFilters = valueFilters;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
