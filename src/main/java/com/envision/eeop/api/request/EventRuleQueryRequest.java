package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionPaginationRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventRuleQueryResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author jonnas.li
 */
@Deprecated
public class EventRuleQueryRequest extends EnvisionPaginationRequest<EventRuleQueryResponse> {
    private static final String APP_METHOD = "/eventService/queryrule";

    private String mdmIdList;

    boolean includeInvalid;

    public EventRuleQueryRequest(String mdmIdList, boolean includeInvalid) {
        this.mdmIdList = mdmIdList;
        this.includeInvalid = includeInvalid;
    }

    public EventRuleQueryRequest(String mdmIdList, boolean includeInvalid, int pageNo, int pageSize) {
        this.mdmIdList = mdmIdList;
        this.includeInvalid = includeInvalid;
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    public EventRuleQueryRequest(List<String> mdmIdList, boolean includeInvalid) {
        this.mdmIdList = StringUtils.listToString(mdmIdList, ",");
        this.includeInvalid = includeInvalid;
    }

    public EventRuleQueryRequest(List<String> mdmIdList, boolean includeInvalid, int pageNo, int pageSize) {
        this.mdmIdList = StringUtils.listToString(mdmIdList, ",");
        this.includeInvalid = includeInvalid;
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    @Override
    public String getApiMethodName() {
        return APP_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmIdList", mdmIdList);
        txtParams.put("includeInvalid", String.valueOf(includeInvalid));
        txtParams.putAll(getPaginationParams());
        return txtParams;
    }

    @Override
    public Class<EventRuleQueryResponse> getResponseClass() {
        return EventRuleQueryResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(mdmIdList, "mdmIdList");
    }

    public String getMdmIdList() {
        return mdmIdList;
    }

    public void setMdmIdList(String mdmIdList) {
        this.mdmIdList = mdmIdList;
    }

    public boolean isIncludeInvalid() {
        return includeInvalid;
    }

    public void setIncludeInvalid(boolean includeInvalid) {
        this.includeInvalid = includeInvalid;
    }
}

