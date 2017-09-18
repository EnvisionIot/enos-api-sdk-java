package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserGetUserInfoResponse extends EnvisionResponse {
    private static final long serialVersionUID = 1796635878045158934L;
    private String userId;
    private String mobile;
    private String areaCode;
    private String email;
    private String orgCode;
    private Map<String, String> userInfoAttributes = new HashMap<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Map<String, String> getUserInfoAttributes() {
        return userInfoAttributes;
    }

    public void setUserInfoAttributes(Map<String, String> userInfoAttributes) {
        this.userInfoAttributes = userInfoAttributes;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
