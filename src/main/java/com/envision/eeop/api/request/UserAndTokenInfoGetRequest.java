package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserAndTokenInfoGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zuoyong.tang on 2018/5/15.
 */
public class UserAndTokenInfoGetRequest implements EnvisionRequest<UserAndTokenInfoGetResponse>{
    private static final String API_METHOD = "/userService/getUserAndTokenInfoBySessionId";

    private String sessionId;

    public UserAndTokenInfoGetRequest(String sessionId){
        this.sessionId = sessionId;
    }

    public String getApiMethodName(){
        return API_METHOD;
    }

    public Map<String, String> getTextParams(){
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("sessionid", sessionId);

        return txtParams;
    }

    public Class<UserAndTokenInfoGetResponse> getResponseClass(){
        return UserAndTokenInfoGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(sessionId, "sessionId");
        // RuleCheckUtils.checkNotEmpty(token, "token");
    }
}


