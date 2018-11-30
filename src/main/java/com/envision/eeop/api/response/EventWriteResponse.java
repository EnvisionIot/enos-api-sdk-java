package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.event.bean.Event;

import java.util.List;

/**
 * Created by alan.wang on 2018/6/25.
 */
public class EventWriteResponse extends EnvisionResponse {

    private static final long serialVersionUID = -6096572939795717109L;
    private List<String> eventIdList;

    public List<String> getEventIdList() {
        return eventIdList;
    }

    public void setEventIdList(List<String> eventIdList) {
        this.eventIdList = eventIdList;
    }
}
