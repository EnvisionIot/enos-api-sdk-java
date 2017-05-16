package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventConfirmGetResponse;
import com.envision.eeop.api.util.EventJsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.expression.Filter;

public class EventConfirmRequest implements EnvisionRequest<EventConfirmGetResponse> {

	private static final String API_METHOD = "/eventService/confirm";

	private Filter filter;
	private String confirmPerson;
	// 确认值(缺省为：1)
	private int value;

	public EventConfirmRequest(Filter filter, String confirmPerson) {
		this(filter, confirmPerson, 1);
	}

	public EventConfirmRequest(Filter filter, String confirmPerson, int value) {
		this.filter = filter;
		this.confirmPerson = confirmPerson;
		this.value = value;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("filter", EventJsonParser.toJson(filter));
		params.put("confirmPerson", confirmPerson);
		params.put("value", String.valueOf(value));
		return params;
	}

	@Override
	public Class<EventConfirmGetResponse> getResponseClass() {
		return EventConfirmGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotNull(filter, "filter");
		RuleCheckUtils.checkNotEmpty(confirmPerson, "confirmPerson");

	}

}
