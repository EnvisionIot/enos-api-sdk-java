package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.CloudedgeAppGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class CloudedgeAppGetRequest implements EnvisionRequest<CloudedgeAppGetResponse> {

	private static final String API_METHOD = "/cloudedge/apps/get";

	private String namespace;

	
	/**
	 * 获取客户id创建的云端盒子app列表
	 * 
	 * @param namespace 客户id
	 */
	public CloudedgeAppGetRequest(String namespace) {
		this.namespace = namespace;

	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();

		txtParams.put("namespace", namespace);

		return txtParams;
	}

	@Override
	public Class<CloudedgeAppGetResponse> getResponseClass() {
		return CloudedgeAppGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(namespace, "namespace");
	}

}
