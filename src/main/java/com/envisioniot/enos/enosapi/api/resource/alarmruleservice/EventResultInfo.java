package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;

import java.io.Serializable;
import java.util.List;

public class EventResultInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    public static String succeed="SUCCEED";
    public static String failed="FAILED";
    public static String partially_succeed="PARTIALLY_SUCCEED";
    private String status;
    private List<String> eventIds;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<String> eventIds) {
        this.eventIds = eventIds;
    }
    public EventResultInfo() {
        super();
    }
    public EventResultInfo(String status, List<String> eventIds) {
        super();
        this.status = status;
        this.eventIds = eventIds;
    }

    @Override
    public String toString() {
        return "EventResultInfo [status=" + status + ", eventIds=" + eventIds + "]";
    }
}

