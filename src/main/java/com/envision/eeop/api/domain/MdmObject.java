/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class MdmObject extends MdmObjectAttributes {

	private static final long serialVersionUID = -4914612001721892494L;

	@SerializedName("mdmid")
	private String mdmID;
	
	public MdmObject() {
		super();
	}

	public MdmObject(String mdmID, Map<String,String> attributes) {
		super(attributes);
		this.mdmID = mdmID;
	}
	
	public MdmObject(String mdmID, String attributesJson) {
		super(attributesJson);
		this.mdmID = mdmID;
	}

	public String getMdmID() {
		return mdmID;
	}

	@Override
	public String toString() {
		return "MdmObject [mdmID=" + mdmID + 
				", attributes=" + attributes + "]";
	}
}
