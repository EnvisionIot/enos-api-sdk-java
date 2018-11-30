package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventListResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;
import com.envision.event.util.FieldFilter;
import com.envision.event.util.FilterList;
import com.envision.event.util.SingleFieldFilter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;


public class EventListByCustomerRequest implements EnvisionRequest<EventListResponse> {
    private static final String API_METHOD = "/eventService/getEvents";

    private static final Integer mdmType = 0;

    private String mdmIds;

    private String pageNo;

    private String beginTime;

    private String endTime;

    private FieldFilter fieldFilter;

    private Integer limit;


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }


    public EventListByCustomerRequest(String mdmId,
                                      String beginTime,
                                      String endTime) {
        this.mdmIds = mdmId;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public EventListByCustomerRequest(String mdmId,
                                      String beginTime,
                                      String endTime,
                                      String pageNo) {
        this(mdmId, beginTime, endTime);
        this.pageNo = pageNo;
    }

    public EventListByCustomerRequest(String mdmId,
                                      String beginTime,
                                      String endTime,
                                      String pageNo,
                                      FieldFilter fieldFilter) {
        this(mdmId, beginTime, endTime, pageNo);
        this.fieldFilter = fieldFilter;

    }

    public EventListByCustomerRequest(String mdmId,
                                      String beginTime,
                                      String endTime,
                                      String pageNo,
                                      FieldFilter fieldFilter,
                                      Integer limit) {
        this(mdmId, beginTime, endTime, pageNo, fieldFilter);
        this.limit = limit;

    }

    public void setMdmIdList(List<String> mdmIdList) {
        this.mdmIds = StringUtils.listToString(mdmIdList, ",");
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setFieldFilter(FieldFilter fieldFilter) {
        this.fieldFilter = fieldFilter;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        txtParams.put("mdmType", mdmType);
        txtParams.put("pageNo", pageNo);
        txtParams.put("mdmIds", mdmIds);
        txtParams.put("begin_time", beginTime);
        txtParams.put("end_time", endTime);
        if (null == fieldFilter) {
            txtParams.put("valueFilters", fieldFilter);
        } else {
            txtParams.put("valueFilters", gson.toJson(fieldFilter));
        }
        txtParams.put("pageSize", limit);

        return txtParams;
    }

    @Override
    public Class<EventListResponse> getResponseClass() {
        return EventListResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
//        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmIds");
//        RuleCheckUtils.checkNotEmpty(metricList, "metrics");
//        RuleCheckUtils.checkNotEmpty(beginTime, "begin_time");
//        RuleCheckUtils.checkDateFormat(beginTime, "begin_time", endTime, "end_time");
    }


    public static void main(String[] args) {
        SingleFieldFilter.Comparator comparator = SingleFieldFilter.Comparator.EQ;
        SingleFieldFilter singleFieldFilter = new SingleFieldFilter("a", comparator, 0.5);
        SingleFieldFilter.Comparator comparator2 = SingleFieldFilter.Comparator.IN;
        SingleFieldFilter singleFieldFilter2 = new SingleFieldFilter("B", comparator2, "ADF");
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(singleFieldFilter));

        FilterList.Operator operator = FilterList.Operator.OR;
        FilterList filterList = new FilterList(operator);
        filterList.addFilter(singleFieldFilter);
        filterList.addFilter(singleFieldFilter2);
        System.out.println(gson.toJson(filterList));
    }

}
