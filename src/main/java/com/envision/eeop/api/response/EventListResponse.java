package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.event.util.PagedList;
import com.envision.event.bean.Event;

/**
 * Created by alan.wang on 2018/6/25.
 */
public class EventListResponse extends EnvisionResponse {
    private static final long serialVersionUID = 4189147451036990068L;

    private PagedList<Event> eventPagedList;

    public PagedList<Event> getEventPagedList() {
        return eventPagedList;
    }

    public void setEventPagedList(PagedList<Event> eventPagedList) {
        this.eventPagedList = eventPagedList;
    }
}
