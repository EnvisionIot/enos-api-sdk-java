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

	/**
	 * detach一个设备
	 * 
	 * @param mdmid
	 *            设备的主数据id
	 * @param appId
	 *            云端盒子app的id号
	 * @param device
	 *            设备模板id
	 * @param attrs
	 *            诸如logicalID， realPointOffset_0，realPointOffset_1,
	 *            realPointOffset_2等信息
	 */
	public CloudedgeDetachDeviceRequest(String mdmid) {
		this.mdmid = mdmid;

	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();

		txtParams.put("mdmid", mdmid);

		return txtParams;
	}

	@Override
	public Class<CloudedgeDetachDeviceResponse> getResponseClass() {
		return CloudedgeDetachDeviceResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
	}

}
