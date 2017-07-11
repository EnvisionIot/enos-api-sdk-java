package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqi.yang on 2017/7/11.
 */
public class UserGetResourceResponse extends EnvisionResponse {
    private static final long serialVersionUID = 6772480046709707967L;
    private List<Resource> resources = new ArrayList<>();

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public class Resource implements Serializable{
        private static final long serialVersionUID = 305589572130111023L;

        private String appId;
        private String resourceId;
        private String resourceType;
        private String scopeId;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getResourceId() {
            return resourceId;
        }

        public void setResourceId(String resourceId) {
            this.resourceId = resourceId;
        }

        public String getResourceType() {
            return resourceType;
        }

        public void setResourceType(String resourceType) {
            this.resourceType = resourceType;
        }

        public String getScopeId() {
            return scopeId;
        }

        public void setScopeId(String scopeId) {
            this.scopeId = scopeId;
        }
    }
}
