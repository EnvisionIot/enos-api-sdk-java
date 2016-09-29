package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.Map;

/**
 * This class defines a Location Based Near filter 
 * @author jieyuan.shen
 */
public class LocBaseNearFilter extends AppointedFilter {

	private static final long serialVersionUID = 8553527930543283656L;
	
	public static final String OPERATOR = "@@near";
	public static final String KEY_LONGITUDE 	= "longitude";
	public static final String KEY_LATITUDE 	= "latitude";
	public static final String KEY_MAX_DISTANCE = "maxDistance";

	public LocBaseNearFilter() {
		super();
	}
	
	public LocBaseNearFilter(Map<String,Map<String,String>> filter) {
		super();
		putAll(filter);
	}
	
	public LocBaseNearFilter(double longitude, double latitude, double maxDistance) {
		super();
		Map<String,String> spec = new HashMap<>();
		spec.put(KEY_LONGITUDE, String.valueOf(longitude));
		spec.put(KEY_LATITUDE, String.valueOf(latitude));
		spec.put(KEY_MAX_DISTANCE, String.valueOf(maxDistance));
		put(OPERATOR, spec);
	}
	
	public double getLongitude() {
		return Double.parseDouble(get(OPERATOR).get(KEY_LONGITUDE));
	}
	
	public double getLatitude() {
		return Double.parseDouble(get(OPERATOR).get(KEY_LATITUDE));
	}
	
	public double getMaxDistance() {
		return Double.parseDouble(get(OPERATOR).get(KEY_MAX_DISTANCE));
	}
}
