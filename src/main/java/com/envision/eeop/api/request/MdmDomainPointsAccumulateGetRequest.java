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
import com.envision.eeop.api.response.MdmDomainPointsValueGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

/**
 * MdmDomainPointsGetRequest
 */
public class MdmDomainPointsAccumulateGetRequest implements EnvisionRequest<MdmDomainPointsValueGetResponse>{
	private static final String API_METHOD = "/domainService/getaccumulatepoints"; 
	
	private String mdmIDList;
	
	private String pointIDList;
	
	private String time_group;
	
	/**
	 * @param mdmIDList
	 * @param pointIDList
	 * @param time_group
	 */
	public MdmDomainPointsAccumulateGetRequest(List<String> mdmIDList,
			List<String> pointIDList, String time_group) {
		this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
		this.pointIDList = StringUtils.listToString(pointIDList, ',');
		this.time_group = time_group;
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
		txtParams.put("time_group", this.time_group);
		
		return txtParams;
	}

	@Override
	public Class<MdmDomainPointsValueGetResponse> getResponseClass() {
		return MdmDomainPointsValueGetResponse.class;
	}
	
	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmIDList,"mdmids");
		RuleCheckUtils.checkNotEmpty(pointIDList,"points");
		RuleCheckUtils.checkNotEmpty(time_group,"time_group");
	}

}
