/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmDomainPointsDetailGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

/**
 * MdmIDListByValueGetRequest
 */
public class MdmDomainPointDetailGetRequest implements EnvisionRequest<MdmDomainPointsDetailGetResponse>{
	private static final String API_METHOD = "/domainService/getPointDetail"; 
	
	private String mdmID;
		
	private String point;
		
	private String fieldList; //optional
	
	private String beginTime;
	
	private String endTime;
	
	private Integer boundaryFlag; //optional


	/**
	 * @param mdmID
	 * @param point
	 * @param beginTime
	 * @param endTime
	 */
	public MdmDomainPointDetailGetRequest(String mdmID, String point,
			String beginTime, String endTime) {
		super();
		this.mdmID = mdmID;
		this.point = point;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public String getMdmID() {
		return mdmID;
	}

	public void setMdmID(String mdmID) {
		this.mdmID = mdmID;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<String> fieldList) {
		this.fieldList = StringUtils.listToString(fieldList, ',');
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
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

	public Integer getBoundaryFlag() {
		return boundaryFlag;
	}

	public void setBoundaryFlag(Integer boundaryFlag) {
		this.boundaryFlag = boundaryFlag;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("mdmid", this.mdmID);
		txtParams.put("point", this.point);
		if (!StringUtils.isEmpty(fieldList)) {
			txtParams.put("fields", this.fieldList);
		}
		txtParams.put("begin_time", this.beginTime);
		txtParams.put("end_time", this.endTime);
		if (boundaryFlag != null) {
			txtParams.put("boundary_flag", this.boundaryFlag);
		}

		return txtParams;
	}

	@Override
	public Class<MdmDomainPointsDetailGetResponse> getResponseClass() {
		return MdmDomainPointsDetailGetResponse.class;
	}
	
	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmID,"mdmid");
		RuleCheckUtils.checkNotEmpty(point,"point");
		RuleCheckUtils.checkNotEmpty(beginTime,"begin_time");
		RuleCheckUtils.checkNotEmpty(endTime,"end_time");
	}

}
