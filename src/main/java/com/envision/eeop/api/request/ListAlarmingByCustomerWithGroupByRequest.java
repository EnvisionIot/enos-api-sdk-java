package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.GroupByResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.event.util.FieldFilter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

/**
 * Created by haifeng.zhu on 2018/8/13.
 */
public class ListAlarmingByCustomerWithGroupByRequest implements EnvisionRequest<GroupByResponse> {
    private static final String API_METHOD = "/eventService/listAlarmingByCustomerWithGroupBy";
    private String customerId;

    private String pageNo;

    private String beginTime;

    private String endTime;

    private FieldFilter fieldFilter;

    private String groupByField;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public FieldFilter getFieldFilter() {
        return fieldFilter;
    }

    public void setFieldFilter(FieldFilter fieldFilter) {
        this.fieldFilter = fieldFilter;
    }

    public String getGroupByField() {
        return groupByField;
    }

    public void setGroupByField(String groupByField) {
        this.groupByField = groupByField;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }
    @Override
    public void check() throws EnvisionRuleException {}
    @Override
    public Class<GroupByResponse> getResponseClass() {
        return GroupByResponse.class;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        txtParams.put("customerId", customerId);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        if (null == fieldFilter) {
            txtParams.put("valueFilters", fieldFilter);
        } else {
            txtParams.put("valueFilters", gson.toJson(fieldFilter));
        }
        txtParams.put("groupByField", groupByField);

        return txtParams;
    }
}
