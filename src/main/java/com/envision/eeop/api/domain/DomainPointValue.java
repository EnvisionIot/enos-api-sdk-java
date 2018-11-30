/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * The Point's Value
 *
 */
public class DomainPointValue implements Serializable {
	private static final long serialVersionUID = 1387363121722151950L;

	// point value
	protected String value;

	// point collection time(ms)
	protected Long timestamp;

	// point attributes with <attr_name, attr_value>
	protected Map<String, String> attributes;

	public DomainPointValue() {
	}

	/**
	 * @param value
	 * @param timestamp
	 * @param attributes
	 */
	public DomainPointValue(String value, long timestamp, Map<String, String> attributes) {
		this.value = value;
		this.timestamp = timestamp;
		this.attributes = attributes;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "PointValue [value=" + value + ", timestamp=" + timestamp
				+ ", attributes=" + attributes + "]";
	}
}
