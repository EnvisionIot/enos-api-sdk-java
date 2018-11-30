package com.envision.eeop.api.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class defines prototype of the Appointed Filter
 * @author jieyuan.shen
 */
public class AppointedFilter extends HashMap<String,Map<String,Object>> implements Serializable {

	private static final long serialVersionUID = 6655822598338711375L;
	
	public AppointedFilter() {
	}

	public AppointedFilter append(AppointedFilter filter){
		putAll(filter);
		return this;
	}

}
