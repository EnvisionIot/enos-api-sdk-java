package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.CloudedgeSubmitDeviceResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CloudedgeSubmitDeviceRequest implements EnvisionRequest<CloudedgeSubmitDeviceResponse> {

	private static final String API_METHOD = "/cloudedge/device/attach";

	private static final Gson gson = new GsonBuilder().create();
	final private String appId;
	final private String namespace;

	/**
	 * 
	 * @param namespace
	 * @param appId
	 */
	public CloudedgeSubmitDeviceRequest(String namespace, String appId) {
		this.appId = appId;

		this.namespace = namespace;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("appid", appId);
		txtParams.put("namespace", namespace);
		return txtParams;
	}

	@Override
	public Class<CloudedgeSubmitDeviceResponse> getResponseClass() {
		return CloudedgeSubmitDeviceResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(appId, "appid");
		RuleCheckUtils.checkNotEmpty(namespace, "namespace");
	}

}
