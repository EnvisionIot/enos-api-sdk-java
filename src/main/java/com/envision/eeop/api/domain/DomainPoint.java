/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * Domain Point
 */
public class DomainPoint implements Serializable{
	private static final long serialVersionUID = 5407474725802446459L;
	
	@SerializedName("points")
	private  Map<String, DomainPointValue> pointValueMap = new HashMap<String, DomainPointValue>();
	
	public DomainPoint() {
	}
	
	public void put(String key, DomainPointValue value){
		pointValueMap.put(key, value);
	}

	public Map<String, DomainPointValue> getPointValueMap() {
		return pointValueMap;
	}

	public void setPointValueMap(Map<String, DomainPointValue> pointValueMap) {
		this.pointValueMap = pointValueMap;
	}
}
