package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserGetRolesResponse extends EnvisionResponse {
    private static final long serialVersionUID = -143939732701383160L;
    @SerializedName("roles")
    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public class Role implements Serializable{

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
}
