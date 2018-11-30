package com.envision.eeop.api.domain;

import java.io.Serializable;

public class AuthResource implements Serializable {
    private static final long serialVersionUID = 1566963342426820680L;

    private String resourceId;
        private String resourceType;

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
    }