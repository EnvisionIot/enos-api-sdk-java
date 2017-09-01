package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventInvalidResponse;
import com.envision.eeop.api.util.RuleCheckUtils;

public class EventInvalidRequest implements EnvisionRequest<EventInvalidResponse> {

	private static final String API_METHOD = "/eventService/invalid";

	private String globalIds;
	private boolean includingHistory;

	public EventInvalidRequest(String globalIds) {
		this.globalIds = globalIds;
		this.includingHistory = false;
	}

	// public EventInvalidRequest(String globalId, boolean includingHistory) {
	// this.globalId = globalId;
	// this.includingHistory = includingHistory;
	// }

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("globalIds", globalIds);
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

}
