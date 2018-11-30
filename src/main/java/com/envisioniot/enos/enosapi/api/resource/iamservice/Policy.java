package com.envisioniot.enos.enosapi.api.resource.iamservice;

import java.io.Serializable;

public class Policy implements Serializable {
    private static final long serialVersionUID = -5941038959450115296L;

    private long id;
    private String orgId;
    private String name;
    private String desc;
    private String createdByUserId;
    private String createdAt;
    private String updatedAt;

    // If you add fields, please add getter and setter methods
    // Don't delete it if you add another constructor.
    public Policy() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
