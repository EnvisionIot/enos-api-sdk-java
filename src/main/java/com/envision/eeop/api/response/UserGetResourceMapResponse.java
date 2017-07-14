package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/7/13.
 */
public class UserGetResourceMapResponse extends EnvisionResponse {
    private static final long serialVersionUID = 6060423141394524603L;

    private Map<String, List<Resource>> userResourceMap = new HashMap<>();

    public Map<String, List<Resource>> getUserResourceMap() {
        return userResourceMap;
    }

    public void setUserResourceMap(Map<String, List<Resource>> userResourceMap) {
        this.userResourceMap = userResourceMap;
    }

    public class Resource implements Serializable {
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
