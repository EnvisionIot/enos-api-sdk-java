package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

public class CloudedgeSubmitDeviceResponse extends EnvisionResponse {

	private static final long serialVersionUID = 1L;

	private final int total;

	public CloudedgeSubmitDeviceResponse(int total) {
		super();
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

}
