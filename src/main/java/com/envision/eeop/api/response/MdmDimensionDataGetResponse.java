package com.envision.eeop.api.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

public class MdmDimensionDataGetResponse extends EnvisionResponse {

	private static final long serialVersionUID = -3105723292588275406L;

	@SerializedName("data")
	private List<Map<String,String>> dimensionData = new ArrayList<>();

	public List<Map<String, String>> getDimensionData() {
		return dimensionData;
	}

	public void setDimensionData(List<Map<String, String>> dimensionData) {
		this.dimensionData = dimensionData;
	}
}
