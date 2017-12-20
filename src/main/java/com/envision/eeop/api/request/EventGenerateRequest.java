package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventGenerateResponse;
import com.envision.eeop.api.util.EventJsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.bo.GenerateEvent;

public class EventGenerateRequest implements EnvisionRequest<EventGenerateResponse> {

	private static final String API_METHOD = "/eventService/generate";

	private List<GenerateEvent> events;

	public EventGenerateRequest(List<GenerateEvent> events) {
		this.events = events;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("events", EventJsonParser.toJson(events));
		return params;
	}

	@Override
	public Class<EventGenerateResponse> getResponseClass() {
		return EventGenerateResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotNull(events, "events");
	}

	public static void main(String[] args) {


	}
	
}
