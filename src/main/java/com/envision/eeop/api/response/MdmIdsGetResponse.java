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
import com.google.gson.annotations.SerializedName;

/**
 * MdmDomainPoints
 */
public class MdmIdsGetResponse  extends EnvisionResponse  {
	private static final long serialVersionUID = 5492232921270771146L;
	@SerializedName("result")
	private List<String> mdmIDList;

	public List<String> getMdmIDList() {
		return mdmIDList;
	}

	public void setMdmIDList(List<String> mdmIDList) {
		this.mdmIDList = mdmIDList;
	}
}
