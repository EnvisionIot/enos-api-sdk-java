package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainSchemasGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class DomainSchemasGetRequest implements EnvisionRequest<DomainSchemasGetResponse> {
	private static final String API_METHOD = "/mdmService/getSchemas"; 

	private String mdmIDList;			// mandatory
	
	private String fieldList;				// optional

	public DomainSchemasGetRequest(List<String> mdmIDList) {
		this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
	}
	
	public DomainSchemasGetRequest(List<String> mdmIDList, List<String> fieldList) {
		this.mdmIDList = StringUtils.listToString(mdmIDList, ',');
		this.fieldList = StringUtils.listToString(fieldList, ',');
	}

	public String getMdmIDList() {
		return mdmIDList;
	}

	public void setMdmIDList(String mdmIDList) {
		this.mdmIDList = mdmIDList;
	}

	public String getFieldList() {
		return fieldList;
	}

	public void setFieldList(String fieldList) {
		this.fieldList = fieldList;
	}

	public String getApiMethodName() {
		return API_METHOD;
	}

	public Map<String, String> getTextParams() {		
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("mdmids", this.mdmIDList);
		if (!StringUtils.isEmpty(fieldList)) {
			txtParams.put("fields", this.fieldList);
		}
		
		return txtParams;
	}

	public Class<DomainSchemasGetResponse> getResponseClass() {
		return DomainSchemasGetResponse.class;
	}
	
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmIDList, "mdmids");
	}
	
}
