package com.envision.eeop.api.request;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventInvalidResponse;
import com.envision.eeop.api.util.EventJsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.google.gson.reflect.TypeToken;

public class EventInvalidRequest implements EnvisionRequest<EventInvalidResponse> {

	private static final String API_METHOD = "/eventService/invalid";
	
	public static final Type typeOfStringList = new TypeToken<List<String>>() {
	}.getType();
	

	private List<String> globalIds;
	private boolean includingHistory;

	public EventInvalidRequest(List<String> globalIds) {
		this.globalIds = globalIds;
		this.includingHistory = false;
	}

	public EventInvalidRequest(List<String> globalIds, boolean includingHistory) {
		this.globalIds = globalIds;
		this.includingHistory = includingHistory;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("globalIds", EventJsonParser.toJson(globalIds, typeOfStringList));
		params.put("includingHistory", "" + includingHistory);

		return params;
	}

	@Override
	public Class<EventInvalidResponse> getResponseClass() {
		return EventInvalidResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(globalIds, "globalIds");
	}
	
	public static void main(String[] args){
		List<String> globalIds=new ArrayList<>();
		globalIds.add("xx");
		globalIds.add("x");
		
		
		System.out.println(EventJsonParser.toJson(globalIds, typeOfStringList));
	}

}
