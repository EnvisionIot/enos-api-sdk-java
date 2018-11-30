package com.envision.eeop.api.request;

import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.domain.CloudedgeDevice;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.CloudedgeAttachDeviceResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CloudedgeAttachDeviceRequest implements EnvisionRequest<CloudedgeAttachDeviceResponse> {

	private static final String API_METHOD = "/cloudedge/device/attach";

	private static final Gson gson = new GsonBuilder().create();

	final private String appId;
	final private List<CloudedgeDevice> devices;
	final private String namespace;
	final private Boolean issubmit;

	/**
	 * 往云端盒子添加设备，并发布
	 * 
	 * @param namespace
	 *            客户id
	 * @param appId
	 *            云端盒子app id号
	 * @param devices 设备列表
	 */
	public CloudedgeAttachDeviceRequest(String namespace, String appId, List<CloudedgeDevice> devices) {
		this.appId = appId;
		this.devices = devices;
		this.namespace=namespace;
		this.issubmit=true;
	}
	
	/**
	 * 往云端盒子添加设备
	 * 
	 * @param namespace 客户id
	 * @param appId 云端盒子app id号
	 * @param devices 设备列表
	 * @param isSubmit 是否需要发布，如果为false，需要额外再请求CloudedgeSubmitDeviceReqeust
	 */
	public CloudedgeAttachDeviceRequest(String namespace, String appId, List<CloudedgeDevice> devices, boolean isSubmit) {
		this.appId = appId;
		this.devices = devices;
		this.namespace=namespace;
		this.issubmit=isSubmit;
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
		txtParams.put("devices", gson.toJson(devices));
		txtParams.put("issubmit", issubmit);

		return txtParams;
	}
	
	public static void main(String [] args){
		boolean is=false;
		EnvisionHashMap txtParams = new EnvisionHashMap();
		txtParams.put("xx", is)	;
	}

	@Override
	public Class<CloudedgeAttachDeviceResponse> getResponseClass() {
		return CloudedgeAttachDeviceResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(appId, "appid");
		RuleCheckUtils.checkNotNull(devices, "devices");
		RuleCheckUtils.checkNotEmpty(namespace, "namespace");
	}

}
