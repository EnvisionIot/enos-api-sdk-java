package com.envision.eeop.api;

import java.util.Map;

public class CloudedgeApp {

	final private String appId;

	final private Map<String, Object> properties;

	public CloudedgeApp(String appId, Map<String, Object> properties) {
		super();
		this.appId = appId;
		this.properties = properties;
	}

	public String getAppId() {
		return appId;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

}
