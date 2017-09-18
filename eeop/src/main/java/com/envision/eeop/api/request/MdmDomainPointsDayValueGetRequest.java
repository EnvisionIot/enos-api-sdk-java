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
 * MdmDomainPointsDayValueGetRequest
 */
public class MdmDomainPointsDayValueGetRequest implements EnvisionRequest<MdmDomainPointsGetResponse> {
    private static final String API_METHOD = "/domainService/getdayvalues";

    private String mdmIDList;

    private String pointIDList;

    /**
     * @param mdmIDList
     * @param pointIDList
     */
    public MdmDomainPointsDayValueGetRequest(List<String> mdmIDList,
                                             List<String> pointIDList) {
        this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
        this.pointIDList = StringUtils.listToString(pointIDList, ',');
    }

    public String getMdmIDList() {
        return mdmIDList;
    }

    public void setMdmIDList(String mdmIDList) {
        this.mdmIDList = mdmIDList;
    }


    public String getPointIDLists() {
        return pointIDList;
    }

    public void setPointIDLists(String pointIDLists) {
        this.pointIDList = pointIDLists;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmids", this.mdmIDList);
        txtParams.put("points", this.pointIDList);

        return txtParams;
    }

    @Override
    public Class<MdmDomainPointsGetResponse> getResponseClass() {
        return MdmDomainPointsGetResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
        RuleCheckUtils.checkNotEmpty(pointIDList, "points");
    }

}
