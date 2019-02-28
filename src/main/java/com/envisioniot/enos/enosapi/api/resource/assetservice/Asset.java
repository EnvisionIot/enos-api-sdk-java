package com.envisioniot.enos.enosapi.api.resource.assetservice;

import java.io.Serializable;
import java.util.Map;

public class Asset implements Serializable {
    private static final long serialVersionUID = -5861719730689538782L;

    private String id;

    private String orgId;

    private TSLStringI18n name;

    private String desc;

    private String timezone;

    private Map<String, Object> attributes;

    private String modelId;

    private Map<String,String> tags;

    // default constructor, don't delete it.
    public Asset() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public TSLStringI18n getName() {
        return name;
    }

    public void setName(TSLStringI18n name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Map<String,String> getTags() {
        return tags;
    }

    public void setTags(Map<String,String> tags) {
        this.tags = tags;
    }
}
