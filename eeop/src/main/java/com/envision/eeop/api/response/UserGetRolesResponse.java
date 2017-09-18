package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.AuthRoleInfo;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserGetRolesResponse extends EnvisionResponse {
    private static final long serialVersionUID = -143939732701383160L;
    @SerializedName("roles")
    private List<AuthRoleInfo> roles = new ArrayList<>();

    public List<AuthRoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<AuthRoleInfo> roles) {
        this.roles = roles;
    }

}
