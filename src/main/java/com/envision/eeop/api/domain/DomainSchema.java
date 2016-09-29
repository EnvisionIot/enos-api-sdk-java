package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class DomainSchema implements Serializable {

	private static final long serialVersionUID = -581311503263219261L;

	@SerializedName("schema")
	private Map<String/*field*/,String> schemaDef;
	
	public DomainSchema() {
	}
	
	public DomainSchema(String schemaId) {
		schemaDef = new HashMap<String, String>();
		schemaDef.put("schema", schemaId);
	}
	
	public void includeDescription(String desc) {
		schemaDef.put("desc", desc);
	}

	public Map<String, String> getSchemaDef() {
		return schemaDef;
	}

	public void setSchemaDef(Map<String, String> schemaDef) {
		this.schemaDef = schemaDef;
	}
	
	@Override
	public String toString() {
		return "DomainSchema [" + schemaDef + "]";
	}
}
