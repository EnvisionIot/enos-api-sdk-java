package com.envision.eeop.api.response;

import java.util.List;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.event.api.Event;

public class EventQueryGetResponse extends EnvisionResponse{

	private static final long serialVersionUID = -1727770275915497602L;

	private List<Event> alarmList;

	private Integer total;

	public List<Event> getAlarmList() {
		return alarmList;
	}

	public void setAlarmList(List<Event> alarmList) {
		this.alarmList = alarmList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer totals) {
		this.total = totals;
	}
}
