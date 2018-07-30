package com.envision.eeop.api.request;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventUpdateResponse;
import com.envision.eeop.api.util.EventJsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.bo.EventUpdate;
import com.envision.eos.event.api.expression.Column;
import com.google.gson.reflect.TypeToken;

public class EventUpdateRequest implements EnvisionRequest<EventUpdateResponse> {

	private static final String API_METHOD = "/eventService/update";

	public static final Type typeOfEventUpdateList = new TypeToken<List<EventUpdate>>() {
	}.getType();

	private List<EventUpdate> events;

	public EventUpdateRequest(List<EventUpdate> events) {
		this.events = events;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();

		params.put("events", EventJsonParser.toJson(events, typeOfEventUpdateList));
		return params;
	}

	@Override
	public Class<EventUpdateResponse> getResponseClass() {
		return EventUpdateResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotNull(events, "events");
	}

	public static void main(String[] args) {
		Map<Column, String> fs = new HashMap<Column, String>();
		fs.put(Column.TAG, "xu");

		EventUpdate event = new EventUpdate("64b1bf748a0e4d038960cb0e94611f55", fs);

		List<EventUpdate> events = new ArrayList<>();
		events.add(event);

		System.out.println(EventJsonParser.toJson(events, typeOfEventUpdateList));

		String ori = EventJsonParser.toJson(events, typeOfEventUpdateList);
		System.out.println(EventJsonParser.toJson(EventJsonParser.fromJson(ori, typeOfEventUpdateList)));

	}

}
