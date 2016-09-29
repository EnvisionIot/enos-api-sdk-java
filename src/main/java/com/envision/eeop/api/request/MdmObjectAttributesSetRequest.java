/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmObjectAttributesSetRequest implements EnvisionRequest<EnvisionResponse>{
	private static final String API_METHOD = "/mdmService/setObjectAttributes"; 

	private String mdmID;				// mandatory
	
	private String attributeList;		// mandatory
	
	public MdmObjectAttributesSetRequest(String mdmID, Map<String,String> attributeValues) {
		this.mdmID = mdmID;
		List<String> attributes = new ArrayList<String>();
		for (String attribute: attributeValues.keySet()) {
			attributes.add(attribute + ":\"" + attributeValues.get(attribute));
		}
		if (!attributes.isEmpty()) {
			attributeList = StringUtils.listToString(attributes, "\",");
			attributeList = attributeList.concat("\"");
		} else {
			attributeList = "";
		}
	}

	public String getMdmID() {
		return mdmID;
	}

	public void setMdmID(String mdmID) {
		this.mdmID = mdmID;
	}

	public String getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(String attributeList) {
		this.attributeList = attributeList;
	}

	public String getApiMethodName() {
		return API_METHOD;
	}

	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("mdmid", this.mdmID);
		txtParams.put("attributes", this.attributeList);
		
		return txtParams;
	}

	public Class<EnvisionResponse> getResponseClass() {
		return EnvisionResponse.class;
	}

	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmID, "mdmid");
		RuleCheckUtils.checkNotEmpty(attributeList,"attributes");
	}
}
