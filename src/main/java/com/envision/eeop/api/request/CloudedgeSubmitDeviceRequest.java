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

	private static final String API_METHOD = "/cloudedge/device/submit";

	final private String appId;
	final private String namespace;

	/**
	 * 发布已添加好的设备
	 * 
	 * @param namespace 客户id
	 * @param appId 云端盒子app id号
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
