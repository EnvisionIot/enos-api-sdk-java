package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.event.bean.Event;
import com.envision.event.util.PagedList;

import java.util.List;

/**
 * Created by alan.wang on 2018/6/25.
 */
public class EventQueryByIdsResponse extends EnvisionResponse {

    private static final long serialVersionUID = 2890558180702877644L;
    private List<Event> eventList;

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

}
