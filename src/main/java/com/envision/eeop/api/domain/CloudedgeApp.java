package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.Map;

public class CloudedgeApp implements Serializable {

	private static final long serialVersionUID = 1L;

	final private String appId;

	final private Map<String, Serializable> properties;

	public CloudedgeApp(String appId, Map<String, Serializable> properties) {
		super();
		this.appId = appId;
		this.properties = properties;
	}

	public String getAppId() {
		return appId;
	}

	public Map<String, Serializable> getProperties() {
		return properties;
	}

}
