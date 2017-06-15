package com.envision.event.api;

import java.io.Serializable;

public class ConfirmValue implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Integer value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}