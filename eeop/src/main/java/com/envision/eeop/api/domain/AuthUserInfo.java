package com.envision.eeop.api.domain;

import java.io.Serializable;

public class AuthUserInfo implements Serializable {
    private static final long serialVersionUID = 2632839279001586104L;
    private String userId;
    private String userName;
    private String orgCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}