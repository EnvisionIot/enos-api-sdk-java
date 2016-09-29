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
import com.envision.eeop.api.response.MdmDomainPointsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

/**
 * MdmDomainPointsGetRequest
 */
public class MdmDomainPointsGetRequest implements EnvisionRequest<MdmDomainPointsGetResponse>{
	private static final String API_METHOD = "/domainService/getmdmidspoints"; 
	
	private String mdmIDList;
	
	private String pointIDList;
	
	private String fieldList;
	
	public MdmDomainPointsGetRequest(List<String> mdmIDList, List<String> pointIDList){
		this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
		this.pointIDList = StringUtils.listToString(pointIDList, ',');
	}
	
	public MdmDomainPointsGetRequest(List<String> mdmIDList, List<String> pointIDList, List<String> fieldList){
		this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
		this.pointIDList = StringUtils.listToString(pointIDList, ',');
		this.fieldList = StringUtils.listToString(fieldList, ',');
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

	public String getApiMethodName() {
		return API_METHOD;
	}

	public Map<String, String> getTextParams() {		
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("mdmids", this.mdmIDList);
		txtParams.put("points", this.pointIDList);
		if(!StringUtils.isEmpty(fieldList)){
			txtParams.put("fields", this.fieldList);
		}
		
		return txtParams;
	}

	public Class<MdmDomainPointsGetResponse> getResponseClass() {
		return MdmDomainPointsGetResponse.class;
	}
	
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmIDList,"mdmids");
		RuleCheckUtils.checkNotEmpty(pointIDList,"points");
	}

}
