package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserRegisterResponse extends EnvisionResponse {
    private static final long serialVersionUID = -8452942974782851868L;

    @SerializedName("userId")
    private String userId;
    private Map<String,String> userAttributes = new HashMap<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, String> getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(Map<String, String> userAttributes) {
        this.userAttributes = userAttributes;
    }
}
