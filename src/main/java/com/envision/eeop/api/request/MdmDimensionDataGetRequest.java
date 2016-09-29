package com.envision.eeop.api.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MdmDimensionDataGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

public class MdmDimensionDataGetRequest implements EnvisionRequest<MdmDimensionDataGetResponse> {

	private static final String API_METHOD = "/mdmService/getDimensionData"; 
	
	private String type;			// mandatory

	private String filterList; 		// optional

	public MdmDimensionDataGetRequest(String type) {
		this.type = type;
		this.filterList = "";
	}

	public MdmDimensionDataGetRequest(String type, Map<String,String> filterSpecs) {
		this.type = type;
		List<String> filters = new ArrayList<String>();
		for (String filter: filterSpecs.keySet()) {
			filters.add(filter + ":\"" + filterSpecs.get(filter));
		}
		if (!filters.isEmpty()) {
			filterList = StringUtils.listToString(filters, "\",");
			filterList = filterList.concat("\"");
		} else {
			filterList = "";
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("type", type);
		txtParams.put("filters", this.filterList);
		return txtParams;
	}

	@Override
	public Class<MdmDimensionDataGetResponse> getResponseClass() {
		return MdmDimensionDataGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(type, "type");
	}

}
