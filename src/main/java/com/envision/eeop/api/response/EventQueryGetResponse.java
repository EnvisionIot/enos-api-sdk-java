package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.internal.event.Event;

public class EventQueryGetResponse extends EnvisionResponse{

	private static final long serialVersionUID = -1727770275915497602L;

	private List<Event> eventList;

	private Integer total;

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> alarmList) {
		this.eventList = alarmList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer totals) {
		this.total = totals;
	}
}
