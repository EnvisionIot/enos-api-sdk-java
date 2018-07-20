package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.event.util.PagedList;
import com.envision.event.bean.Event;

/**
 * Created by alan.wang on 2018/6/25.
 */
public class AlarmingListResponse extends EnvisionResponse {

    private static final long serialVersionUID = 469032266647467477L;
    private PagedList<Event> alarmingPagedList;

    public PagedList<Event> getAlarmingPagedList() {
        return alarmingPagedList;
    }

    public void setAlarmingPagedList(PagedList<Event> alarmingPagedList) {
        this.alarmingPagedList = alarmingPagedList;
    }
}
