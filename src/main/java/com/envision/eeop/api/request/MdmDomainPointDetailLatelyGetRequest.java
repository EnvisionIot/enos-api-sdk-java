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
public class MdmDomainPointDetailLatelyGetRequest implements EnvisionRequest<MdmDomainPointsDetailGetResponse>{
	private static final String API_METHOD = "/domainService/getPointDetailCurrentDay"; 
	
	private String mdmID;
		
	private String point;
		
	private String fieldList;

	/**
	 * @param mdmID
	 * @param point
	 * @param fieldList
	 */
	public MdmDomainPointDetailLatelyGetRequest(String mdmID, String point,
			List<String> fieldList) {
		super();
		this.mdmID = mdmID;
		this.point = point;
		this.fieldList = StringUtils.listToString(fieldList, ',');
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

	public void setFieldList(String fieldList) {
		this.fieldList = fieldList;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {		
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("mdmid", this.mdmID);
		txtParams.put("point", this.point);
		if(!StringUtils.isEmpty(fieldList)){
			txtParams.put("fields", this.fieldList);
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
	}

}
