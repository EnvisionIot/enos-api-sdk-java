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

/**
 * MdmDomainPoints
 */
public class MdmDomainPointsValueGetResponse extends EnvisionResponse {

	private static final long serialVersionUID = -6810193146831085932L;

	@SerializedName("result")
	private Map<String, Map<String, Double>> mdmMap;

	public Map<String, Map<String, Double>> getMdmMap() {
		return mdmMap;
	}

	public void setMdmMap(Map<String, Map<String, Double>> mdmMap) {
		this.mdmMap = mdmMap;
	}
}
