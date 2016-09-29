package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmObjectStructureGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmObjectStructureGetRequest implements EnvisionRequest<MdmObjectStructureGetResponse> {

	private static final String API_METHOD = "/mdmService/getObjectStructure"; 
	
	private String token;			// mandatory
	
	private String type;			// mandatory
	
	private String attributeList;	// optional

	public MdmObjectStructureGetRequest(String token, String type) {
		this.token = token;
		this.type = type;
		// parentID, objectID and objectTypeID are mandatory attributes to describe structure
		this.attributeList = "";
	}
	
	public MdmObjectStructureGetRequest(String token, String type, List<String> attributeList) {
		this.token = token;
		this.type = type;
		this.attributeList = StringUtils.listToString(attributeList, ',');
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		txtParams.put("token", token);
		txtParams.put("type", type);
		txtParams.put("attributes", attributeList);
		
		return txtParams;
	}

	public Class<MdmObjectStructureGetResponse> getResponseClass() {
		return MdmObjectStructureGetResponse.class;
	}
	
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(token, "token");
		RuleCheckUtils.checkNotEmpty(type, "type");
	}
}