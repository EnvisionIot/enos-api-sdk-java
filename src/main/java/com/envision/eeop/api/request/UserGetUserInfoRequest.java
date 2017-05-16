package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserGetUserInfoResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserGetUserInfoRequest implements EnvisionRequest<UserGetUserInfoResponse> {
    private static final String API_METHOD = "/userService/getUserInfo";
    private String userId;
    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public UserGetUserInfoRequest() {
    }

    public UserGetUserInfoRequest(String userId) {
        this.userId = userId;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("userId", this.userId);
        return txtParams;
    }

    @Override
    public Class getResponseClass() {
        return UserGetUserInfoResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.userId, "userId");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
