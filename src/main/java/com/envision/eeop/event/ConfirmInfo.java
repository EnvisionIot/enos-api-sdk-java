package com.envision.eeop.event;

import java.io.Serializable;
import java.util.List;

public class ConfirmInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String siteId;
	private List<ConfirmValue> confirmValues;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public List<ConfirmValue> getConfirmValues() {
		return confirmValues;
	}

	public void setConfirmValues(List<ConfirmValue> confirmValues) {
		this.confirmValues = confirmValues;
	}
}