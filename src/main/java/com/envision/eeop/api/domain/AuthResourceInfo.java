package com.envision.eeop.api.domain;

import java.io.Serializable;

public class AuthResourceInfo implements Serializable {
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