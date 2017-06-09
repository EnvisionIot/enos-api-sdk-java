package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventSRStatusGetResponse;
import com.envision.eeop.api.util.EventJsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.bo.LanguageType;
import com.envision.eos.event.api.expression.Filter;

public class EventSRStatusRequest implements EnvisionRequest<EventSRStatusGetResponse> {

	private static final String API_METHOD = "/eventService/srstatus";

	private Filter filter;
	private String status;

	private LanguageType language;

	public EventSRStatusRequest(Filter filter, String status) {
		this(filter, LanguageType.ZH_CN, status);
	}

	public EventSRStatusRequest(Filter filter, LanguageType language, String status) {
		this.filter = filter;
		this.status = status;

		this.language = language;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("filter", EventJsonParser.toJson(filter));
		params.put("status", status);
		params.put("language", language.toString());
		return params;
	}

	@Override
	public Class<EventSRStatusGetResponse> getResponseClass() {
		return EventSRStatusGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotNull(filter, "filter");
		RuleCheckUtils.checkNotEmpty(status, "status");
	}

}
