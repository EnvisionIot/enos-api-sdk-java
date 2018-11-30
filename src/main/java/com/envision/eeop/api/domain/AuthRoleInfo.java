package com.envision.eeop.api.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthRoleInfo implements Serializable {

        private static final long serialVersionUID = 9138941805796274705L;
        
        @SerializedName("roleId")
        private String roleId;
        @SerializedName("roleName")
        private String roleName;
        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
    }