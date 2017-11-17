package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CloudedgeApp implements Serializable {

	private static final long serialVersionUID = 1L;

	final private String appId;

	final private String name;

	final private Map<String, List<Map<String, String>>> properties;

	public CloudedgeApp(String appId, String name, Map<String, List<Map<String, String>>> properties) {
		this.name = name;
		this.appId = appId;
		this.properties = properties;
	}

	public String getAppId() {
		return appId;
	}

	public Map<String, List<Map<String, String>>> getProperties() {
		return properties;
	}

	public String getName() {
		return name;
	}
	

}
