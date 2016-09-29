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
import com.google.gson.annotations.SerializedName;

/**
 * MdmDomainPointsDetailGetResponse
 */
public class MdmDomainPointsDetailGetResponse  extends EnvisionResponse  {

	private static final long serialVersionUID = 1656404569853231330L;
	
	@SerializedName("result")
	private List<DomainPointValue> domainPointValueList;

	public List<DomainPointValue> getDomainPointValueList() {
		return domainPointValueList;
	}

	public void setDomainPointValueList(List<DomainPointValue> domainPointValueList) {
		this.domainPointValueList = domainPointValueList;
	}


}
