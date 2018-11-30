package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Domain schemas
 * @author jieyuan.shen
 */
public class CountGetResponse extends EnvisionResponse {

	private static final long serialVersionUID = 627716959003640263L;
	
	@SerializedName("count")
	private Integer  count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
