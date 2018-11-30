package com.envision.eeop.api.domain;

import java.io.Serializable;

/**
 * Created by zhiqi.yang on 2017/5/20.
 */
public class UserSetUserSiteVo implements Serializable{
    private static final long serialVersionUID = -2563501983883908893L;
    private String userId;
    private String orgCode;
    private String roleIds;
    private String siteIds;
    private String type;

    public UserSetUserSiteVo() {
    }

    public UserSetUserSiteVo(String userId, String orgCode, String roleIds, String siteIds, String type) {
        this.userId = userId;
        this.orgCode = orgCode;
        this.roleIds = roleIds;
        this.siteIds = siteIds;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(String siteIds) {
        this.siteIds = siteIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
