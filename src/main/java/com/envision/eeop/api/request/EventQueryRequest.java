package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventQueryGetResponse;
import com.envision.eeop.api.util.EventJsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.bo.EventQuery;
import com.envision.eos.event.api.expression.Column;
import com.envision.eos.event.api.expression.Filter;
import com.envision.eos.event.api.expression.LiteralFilter;

public class EventQueryRequest implements EnvisionRequest<EventQueryGetResponse> {

	private static final String API_METHOD = "/eventService/query";

	private EventQuery query;

	public EventQueryRequest(EventQuery query) {
		this.query = query;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("query", EventJsonParser.toJson(query));
		return params;
	}

	@Override
	public Class<EventQueryGetResponse> getResponseClass() {
		return EventQueryGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotNull(query, "query");
	}

//	public static void main(String[] args) {
//
//		// EventQuery query = new EventQuery();
//
//		EventQuery query = new EventQuery("30m-ago", "now");
//		// 以下等价where child_war_type in ("102001") and site_id in
//		// ("179651f09e7ec000")
//		Filter filter = new LiteralFilter(Column.SITE_ID).addLiteral("fac_idxxxx");
//
//		filter = filter.and(new LiteralFilter(Column.DEVICE_ID).addLiteral("deviceidxxxx"));
//		query.setFilter(filter);
//		// 以下等价limit 10,20 可用来分页
//		 query.setS(0);
//		 query.setN(20);
//		// 以下表示只查询总数，相当于select count(*) from xxxx
//		//query.setShowTotal(true);
//		String json = EventJsonParser.toJson(query);
//		System.out.println(json);
//		json="{\"start\":\"30m-ago\",\"end\":\"now\",\"timezone\":\"local\",\"filter\":{\"left\":{\"column\":\"SITE_ID\",\"literals\":[\"fac_idxxxx\"],\"type\":\"LiteralFilter\"},\"right\":{\"column\":\"DEVICE_ID\",\"literals\":[\"deviceidxxxx\"],\"type\":\"LiteralFilter\"},\"type\":\"AndFilter\"},\"s\":0,\"n\":20}";
//		System.out.println(json);
//		EventQuery query1 = EventJsonParser.fromJson(json, EventQuery.class);
//
//		String json1 = EventJsonParser.toJson(query1);
//
//		System.out.println(json1);
//
//	}
	
	public static void main(String[] args) {
		String query = "{\"start\":\"2017-05-01+00:00:00\",\"end\":\"2017-06-01+00:00:00\",\"timezone\":\"local\",\"filter\":{\"column\": \"LEVEL\", \"literals\": [\"999\"], \"type\": \"LiteralFilter\"},\"s\":0,\"n\":3,\"isShowTotal\":true,\"language\":\"ZH_CN\"}";
		EventQuery eventQuery = EventJsonParser.fromJson(query, EventQuery.class);
		System.out.println(query);

	}

}
