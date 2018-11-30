package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CloudedgeDevice implements Serializable {

	private static final long serialVersionUID = 1L;

	final private String mdmid;
	final private int deviceTemplateId;
	final private Map<String, String> attrs;

	/**
	 * 
	 * @param mdmid 设备的主数据id
	 * @param deviceTemplateId  设备模板id
	 * @param attrs  诸如logicalID, realPointOffset_0, realPointOffset_1, realPointOffset_2等信息 
	 */
	public CloudedgeDevice(String mdmid, int deviceTemplateId, Map<String, String> attrs) {
		super();
		this.mdmid = mdmid;
		this.deviceTemplateId = deviceTemplateId;
		this.attrs = attrs;
	}
	
	public CloudedgeDevice(String mdmid, int deviceTemplateId) {
		super();
		this.mdmid = mdmid;
		this.deviceTemplateId = deviceTemplateId;
		this.attrs = new HashMap<String, String>();
	}

	public String getMdmid() {
		return mdmid;
	}

	public int getDeviceTemplateId() {
		return deviceTemplateId;
	}

	public Map<String, String> getAttrs() {
		return attrs;
	}

}
