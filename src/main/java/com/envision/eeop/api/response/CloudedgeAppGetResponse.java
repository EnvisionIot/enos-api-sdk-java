package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.CloudedgeApp;

public class CloudedgeAppGetResponse extends EnvisionResponse {

	private static final long serialVersionUID = 1L;

	final private List<CloudedgeApp> apps;

	final private int total;

	public CloudedgeAppGetResponse(List<CloudedgeApp> apps, int total) {
		this.apps = apps;
		this.total = total;
	}

	public List<CloudedgeApp> getApps() {
		return apps;
	}


	public int getTotal() {
		return total;
	}

}
