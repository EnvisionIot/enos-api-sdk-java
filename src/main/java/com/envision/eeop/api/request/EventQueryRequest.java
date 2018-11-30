package com.envision.eeop.api.request;

import java.util.HashMap;
import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventQueryGetResponse;
import com.envision.eeop.api.util.EventJsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eos.event.api.bo.EventQuery;
import com.envision.eos.event.api.expression.LiteralFilter;
import com.envision.eos.event.api.expression.Aggregate.AggregateType;
import com.envision.eos.event.api.expression.Aggregate;
import com.envision.eos.event.api.expression.Column;
import com.envision.eos.event.api.expression.DateExpr;
import com.envision.eos.event.api.expression.Filter;
import com.envision.eos.event.api.expression.GroupBy;
import com.envision.eos.event.api.expression.HourExpr;


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

	public static void main(String[] args) {

//		EventQuery query = new EventQuery("30m-ago", "now");
//
//		Filter filter = new LiteralFilter(Column.SITE_ID).addLiteral("fac_idxxxx");
//
//		filter = filter.and(new LiteralFilter(Column.DEVICE_ID).addLiteral("deviceidxxxx"));
//		query.setFilter(filter);
//		// 以下等价limit 10,20 可用来分页
//		 query.setS(0);
//		 query.setN(20);
//		 query.setSelectView(new View().addColumnView(Column.DEVICE_ID).addColumnView(Column.CODE));
		
		EventQuery query = new EventQuery("1d-ago", "now");
		Filter filter = new LiteralFilter(Column.SITE_ID).addLiteral("7a40b31aa5014e0e84843c4dad4c9dae");

		query.setFilter(filter);
		
		Aggregate aggregate = new Aggregate(AggregateType.COUNT, Column.ID);
		GroupBy groupBy = new GroupBy();
		groupBy.addColumn(Column.WARN_TYPE);
		groupBy.addExpr(new DateExpr(Column.OCCUR_TIME));
		groupBy.addExpr(new HourExpr(Column.OCCUR_TIME));

		query.addAggregate(aggregate);
		query.setGroupBy(groupBy);
		query.setS(0);
		query.setN(1000);
		query.setShowTotal(true);

		String json = EventJsonParser.toJson(query);
		System.out.println(json);
		EventQuery query1 = EventJsonParser.fromJson(json, EventQuery.class);
		String json1 = EventJsonParser.toJson(query1);

		System.out.println(json1);

	}
	


}
