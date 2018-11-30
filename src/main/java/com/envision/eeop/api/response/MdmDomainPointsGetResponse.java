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
import com.envision.eeop.api.domain.DomainPoint;
import com.google.gson.annotations.SerializedName;

/**
 * MdmDomainPoints
 */
public class MdmDomainPointsGetResponse  extends EnvisionResponse  {
	private static final long serialVersionUID = -3345867387611142216L;
	
	@SerializedName("result")
	private Map<String, DomainPoint> mdmMap;

	public Map<String, DomainPoint> getMdmMap() {
		return mdmMap;
	}

	public void setMdmMap(Map<String, DomainPoint> mdmMap) {
		this.mdmMap = mdmMap;
	}
}
