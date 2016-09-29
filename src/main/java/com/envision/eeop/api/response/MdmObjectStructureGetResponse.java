package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmObject;
import com.google.gson.annotations.SerializedName;

public class MdmObjectStructureGetResponse extends EnvisionResponse {

	private static final long serialVersionUID = 943451741324250846L;

	@SerializedName("data")
	private List<MdmObject> mdmObjects;

	public List<MdmObject> getMdmObjects() {
		return mdmObjects;
	}

	public void setMdmObjects(List<MdmObject> mdmObjects) {
		this.mdmObjects = mdmObjects;
	}
}
