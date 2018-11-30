package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zuoyong.tang on 2018/5/15.
 */
public class EventTypeTree implements Serializable {
    private static final long serialVersionUID = 8554383439355992461L;

    private int id;
    private String eventTypeId;
    private String description;
    private String childEventTypeId;
    private long updatetime;
    private String ns;
    private String category;
    // private String nodeId;
    // private boolean isLeaf;
    private String type;
    // private String nodeName;
    private String tag;
    // private String parentId;
    private List<EventTypeTree> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<EventTypeTree> getChildren() {
        return children;
    }

    public void setChildren(List<EventTypeTree> children) {
        this.children = children;
    }
}
