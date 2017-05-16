package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserLoginByRefreshTokenResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserLoginByRefreshTokenRequest implements EnvisionRequest<UserLoginByRefreshTokenResponse> {
    private static final String API_METHOD = "/userService/loginByRefreshToken";
    private String refreshToke;
    private String userId;

    public UserLoginByRefreshTokenRequest() {
    }

    public UserLoginByRefreshTokenRequest(String refreshToke, String userId) {
        this.refreshToke = refreshToke;
        this.userId = userId;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("refreshToke",this.refreshToke);
        txtParams.put("userId",this.userId);
        return txtParams;
    }

    @Override
    public Class getResponseClass() {
        return UserLoginByRefreshTokenResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.refreshToke, "refreshToke");
        RuleCheckUtils.checkNotEmpty(this.userId, "userId");
    }

    public String getRefreshToke() {
        return refreshToke;
    }

    public void setRefreshToke(String refreshToke) {
        this.refreshToke = refreshToke;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
