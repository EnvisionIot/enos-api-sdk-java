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

import com.envision.eeop.api.util.JsonParser;
import com.google.gson.reflect.TypeToken;

public class MdmObjectAttributes implements Serializable {

	private static final long serialVersionUID = 8325550459061696090L;

	protected Map<String,String> attributes;
	
	public MdmObjectAttributes() {
	}
	
	public MdmObjectAttributes(Map<String,String> attributes) {
		this.attributes = attributes;
	}
	
	public MdmObjectAttributes(String attributesJson) {
		attributes = JsonParser.fromJson(attributesJson, new TypeToken<Map<String,String>>(){}.getType());
	}
	
	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "MdmObject [attributes=" + attributes + "]";
	}
}
