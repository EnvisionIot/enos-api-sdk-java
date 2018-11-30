package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.AuthResource;

import java.util.List;

public class AppResourceGetResponse extends EnvisionResponse{
	private static final long serialVersionUID = 2678397913115966575L;

	private List<AuthResource> data;

	public List<AuthResource> getData() {
		return data;
	}

	public void setData(List<AuthResource> data) {
		this.data = data;
	}
}
