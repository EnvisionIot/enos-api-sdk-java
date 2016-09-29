package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmChildObjects;
import com.google.gson.annotations.SerializedName;

/**
 * MDM Child Objects grouped by parent and type
 * @author jieyuan.shen
 *
 */
public class MdmObjectsGetResponse extends EnvisionResponse {
	
	private static final long serialVersionUID = -3251518557042008764L;

	@SerializedName("data")
	private Map<String/*parent mdmID*/,MdmChildObjects> mdmChildObjects;

	public Map<String, MdmChildObjects> getMdmChildObjects() {
		return mdmChildObjects;
	}

	public void setMdmChildObjects(Map<String, MdmChildObjects> mdmChildObjects) {
		this.mdmChildObjects = mdmChildObjects;
	}
}
