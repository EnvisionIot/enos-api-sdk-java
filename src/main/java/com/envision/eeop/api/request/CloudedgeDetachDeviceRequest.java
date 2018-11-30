package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.CloudedgeDetachDeviceResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class CloudedgeDetachDeviceRequest implements EnvisionRequest<CloudedgeDetachDeviceResponse> {

	private static final String API_METHOD = "/cloudedge/device/detach";

	private String mdmid;
	
	private String namespace;
	
	
	/**
	 * detach一个设备
	 * 
	 * @param namespace 客户id
	 * @param mdmid 设备的主数据id
	 */
	public CloudedgeDetachDeviceRequest(String namespace,String mdmid) {
		this.mdmid = mdmid;
		this.namespace=namespace;

	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("mdmid", mdmid);
		txtParams.put("namespace", namespace);

		return txtParams;
	}

	@Override
	public Class<CloudedgeDetachDeviceResponse> getResponseClass() {
		return CloudedgeDetachDeviceResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
        RuleCheckUtils.checkNotEmpty(namespace, "namespace");
	}

}
