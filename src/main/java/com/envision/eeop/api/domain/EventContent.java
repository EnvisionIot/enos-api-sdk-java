package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zuoyong.tang on 2018/5/14.
 */
public class EventContent implements Serializable {
    private static final long serialVersionUID = 8104018874555688899L;

    private long id;
    private String tag;
    private String category;
    private String eventTypeId;
    private String childEventTypeId;
    private String status;
    private String description;
    private long updatetime;
    private List<Map<String, String>> causeAndSolutionList = new ArrayList<>();
    private String ns;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(String eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getChildEventTypeId() {
        return childEventTypeId;
    }

    public void setChildEventTypeId(String childEventTypeId) {
        this.childEventTypeId = childEventTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }

    public List<Map<String, String>> getCauseAndSolutionList() {
        return causeAndSolutionList;
    }

    public void setCauseAndSolutionList(List<Map<String, String>> causeAndSolutionList) {
        this.causeAndSolutionList = causeAndSolutionList;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }
}
