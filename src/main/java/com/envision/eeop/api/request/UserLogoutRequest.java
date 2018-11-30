package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserLogoutResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserLogoutRequest  implements EnvisionRequest<UserLogoutResponse> {
    private static final String API_METHOD = "/userService/logout";
    private String refreshToken;
    private String userId;

    public UserLogoutRequest() {
    }

    public UserLogoutRequest(String refreshToken, String userId) {
        this.refreshToken = refreshToken;
        this.userId = userId;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("refreshToken", this.refreshToken);
        txtParams.put("userId", this.userId);
        return txtParams;
    }

    @Override
    public Class<UserLogoutResponse> getResponseClass() {
        return UserLogoutResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.refreshToken, "refreshToken");
        RuleCheckUtils.checkNotEmpty(this.userId, "userId");
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
