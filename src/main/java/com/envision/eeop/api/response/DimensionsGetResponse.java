/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;


public class DimensionsGetResponse extends EnvisionResponse {

	private static final long serialVersionUID = 627716959003640263L;
	
	@SerializedName("data")
	private Map<String, Map<String, Object>>  dimensionsMap;

	public Map<String, Map<String, Object>> getDimensions() {
		return dimensionsMap;
	}

	public void setDimensions(Map<String, Map<String, Object>> dimensionsMap) {
		this.dimensionsMap = dimensionsMap;
	}
}
