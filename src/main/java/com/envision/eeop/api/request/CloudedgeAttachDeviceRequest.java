package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
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
	final private String mdmid;
	final private int deviceTemplateId;
	final private String namespace;
	final private Map<String,String> attrs;
	
	
	/**
	 * 将设备mdmid添加到云端盒子app上，并发布
	 * 
	 * @param namespace 客户id
	 * @param mdmid 设备的主数据id
	 * @param appId 云端盒子app id号
	 * @param deviceTemplateId 设备模板id
	 * @param attrs 诸如logicalID, realPointOffset_0, realPointOffset_1, realPointOffset_2等信息 
	 */
	public CloudedgeAttachDeviceRequest(String namespace, String mdmid, String appId, int deviceTemplateId, Map<String, String> attrs){
		this.appId=appId;
		this.mdmid=mdmid;
		this.deviceTemplateId=deviceTemplateId;
		this.attrs=attrs;
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
        txtParams.put("appid", appId);
        txtParams.put("devicetemplateid", deviceTemplateId);
        txtParams.put("namespace", namespace);
        txtParams.put("attrs", gson.toJson(attrs));

        return txtParams;
	}

	@Override
	public Class<CloudedgeAttachDeviceResponse> getResponseClass() {
		return CloudedgeAttachDeviceResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(appId, "appid");
        RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
        RuleCheckUtils.checkNotEmpty(namespace, "namespace");
        RuleCheckUtils.checkMinValue((long) deviceTemplateId,0, "devicetemplateid");
        RuleCheckUtils.checkNotNull(attrs, "attrs");
	}

}
