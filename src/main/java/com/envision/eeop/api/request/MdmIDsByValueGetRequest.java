/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmIdsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

/**
 * MdmIDListByValueGetRequest
 */
public class MdmIDsByValueGetRequest implements EnvisionRequest<MdmIdsGetResponse>{
	private static final String API_METHOD = "/domainService/getmdmidsbyvalue"; 
	
	private String mdmID;
	
	private int direct_child_type;
	
	private String point;
	
	private String value;
	
	/**
	 * @param mdmIDList
	 * @param direct_child_type
	 * @param point
	 * @param value
	 */
	public MdmIDsByValueGetRequest(String mdmID, int direct_child_type,
			String point, String value) {
		super();
		this.mdmID = mdmID;
		this.direct_child_type = direct_child_type;
		this.point = point;
		this.value = value;
	}
	

	public String getMdmID() {
		return mdmID;
	}


	public void setMdmID(String mdmID) {
		this.mdmID = mdmID;
	}


	public int getDirect_child_type() {
		return direct_child_type;
	}

	public void setDirect_child_type(int direct_child_type) {
		this.direct_child_type = direct_child_type;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {		
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("mdmid", this.mdmID);
		txtParams.put("direct_child_type", this.direct_child_type);
		txtParams.put("point", this.point);
		txtParams.put("value", this.value);
		
		return txtParams;
	}

	@Override
	public Class<MdmIdsGetResponse> getResponseClass() {
		return MdmIdsGetResponse.class;
	}
	
	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmID,"mdmid");
		RuleCheckUtils.checkNotEmpty(direct_child_type,"direct_child_type");
		RuleCheckUtils.checkNotEmpty(point,"point");
		RuleCheckUtils.checkNotEmpty(value,"value");
	}

}
