/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DomainPointValue;


public class DevicesPointsGetResponse extends EnvisionResponse {	
	private static final long serialVersionUID = 7045405215401587107L;
	
	private List<List<DomainPointValue>> pointValues;
	
	public List<List<DomainPointValue>> getPointValues() {
		return pointValues;
	}

	public void setPointValues(List<List<DomainPointValue>> pointValues) {
		this.pointValues = pointValues;
	}
}
