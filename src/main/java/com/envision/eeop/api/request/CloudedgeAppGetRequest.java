package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.CloudedgeAppGetResponse;
import com.envision.eeop.api.response.CloudedgeAttachDeviceResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class CloudedgeAppGetRequest implements EnvisionRequest<CloudedgeAppGetResponse> {

	private static final String API_METHOD = "/cloudedge/apps/get";

	private String uid;

	/**
	 * 获取客户id创建的app请求列表
	 * 
	 * @param uid
	 *            客户id
	 */
	public CloudedgeAppGetRequest(String uid) {
		this.uid = uid;

	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();

		txtParams.put("uid", uid);

		return txtParams;
	}

	@Override
	public Class<CloudedgeAttachDeviceResponse> getResponseClass() {
		return CloudedgeAttachDeviceResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(uid, "uid");
	}

}
