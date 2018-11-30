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
import com.envision.eeop.api.response.MdmPointMappingGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmPointMappingGetRequest implements
		EnvisionRequest<MdmPointMappingGetResponse> {
	private static final String API_METHOD = "/mdmService/getDomainPointMapping";

	private String mdmIDList;

	private String pointIDList;

	public MdmPointMappingGetRequest(List<String> mdmIDList,
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
	public Class<MdmPointMappingGetResponse> getResponseClass() {
		return MdmPointMappingGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
		RuleCheckUtils.checkNotEmpty(pointIDList, "points");
	}

}
