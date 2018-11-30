package com.envisioniot.enos.enosapi.api.resource.modelservice;

import com.envisioniot.enos.enosapi.api.resource.assetservice.TSLStringI18n;

import java.io.Serializable;
import java.util.Map;

public class ThingModel implements Serializable {
    private static final long serialVersionUID = -5762570694738818140L;

    private String id;

    private String orgId;

    private TSLStringI18n name;

    private String desc;

    private String category;

    private String jsonschema;

    private String parentId;

    private String copyFromId;

    private Map<String,String> tags;

    // default constructor, don't delete it.
    public ThingModel() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJsonschema() {
        return jsonschema;
    }

    public void setJsonschema(String jsonschema) {
        this.jsonschema = jsonschema;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCopyFromId() {
        return copyFromId;
    }

    public void setCopyFromId(String copyFromId) {
        this.copyFromId = copyFromId;
    }

    public Map<String,String> getTags() {
        return tags;
    }

    public void setTags(Map<String,String> tags) {
        this.tags = tags;
    }
}
