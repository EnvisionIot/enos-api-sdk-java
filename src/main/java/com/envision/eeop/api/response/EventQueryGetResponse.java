package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eos.event.api.bo.Event;

public class EventQueryGetResponse extends EnvisionResponse{

	private static final long serialVersionUID = -1727770275915497602L;

	private List<Event> eventList;

	private Integer total;

	public List<Event> getEventList() {
		return eventList;
	}
	
	@Deprecated
	public List<Event> getAlarmList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer totals) {
		this.total = totals;
	}
}
