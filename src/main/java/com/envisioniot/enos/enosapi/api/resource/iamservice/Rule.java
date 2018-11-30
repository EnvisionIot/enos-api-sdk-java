package com.envisioniot.enos.enosapi.api.resource.iamservice;

import java.io.Serializable;
import java.util.List;

public class Rule implements Serializable {
    private static final long serialVersionUID = -4314994761268362168L;

    private String resourceId;
    private String externalId;
    private List<String> actions;
    private String createdAt;

    // If you add fields, please add getter and setter methods
    // Don't delete it if you add another constructor.
    public Rule() {
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
