package com.envision.eeop.api.request;


import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmDomainPointsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by zhensheng.cai on 2017/8/30.
 */
public class MdmDomainPointsGuestGetRequest implements EnvisionRequest<MdmDomainPointsGetResponse> {
    private static final String API_MEHOD = "/domainService/getmdmidspoints";
    private String fieldName;
    private String fieldValueList;
    private String pointIDList;
    private String fieldList;

    public MdmDomainPointsGuestGetRequest(String fieldName, List<String> filedValueList, List<String> pointIDList) {
        this.fieldName = fieldName;
        this.fieldValueList = StringUtils.listToString(filedValueList,',');
        this.pointIDList = StringUtils.listToString(pointIDList, ',');
    }
    public MdmDomainPointsGuestGetRequest(String fieldName, List<String> fieldValueList, List<String> pointIDList, List<String> fieldList) {
        this.fieldName = fieldName;
        this.fieldValueList = StringUtils.listToString(fieldValueList,',');
        this.pointIDList = StringUtils.listToString(pointIDList, ',');
        this.fieldList = StringUtils.listToString(fieldList, ',');
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValueList() {
        return fieldValueList;
    }

    public void setFieldValueList(String fieldValueList) {
        this.fieldValueList = fieldValueList;
    }

    public String getPointIDList() {
        return pointIDList;
    }

    public void setPointIDList(String pointIDList) {
        this.pointIDList = pointIDList;
    }


    @Override
    public String getApiMethodName() {
        return API_MEHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("guestidattr", this.fieldName);
        txtParams.put("guestids", this.fieldValueList);
        txtParams.put("points", this.pointIDList);
        if(!StringUtils.isEmpty(fieldList)){
            txtParams.put("fields", this.fieldList);
        }

        return txtParams;
    }

    @Override
    public Class<MdmDomainPointsGetResponse> getResponseClass() {
        return MdmDomainPointsGetResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(fieldName,"fieldname");
        RuleCheckUtils.checkNotEmpty(fieldValueList,"fieldvalues");
        RuleCheckUtils.checkNotEmpty(pointIDList,"points");

    }
}
