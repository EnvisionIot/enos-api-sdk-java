package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserSetUserPasswordResponse;
import com.envision.eeop.api.util.AES;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/16.
 */
public class UserSetUserPasswordRequest implements EnvisionRequest<UserSetUserPasswordResponse> {
    private static final String API_METHOD = "/userService/setUserPassword";
    private String verificationCode;
    private String msgType;
    private String userId;
    private String password;
    private String passwordEncrypt;

    public UserSetUserPasswordRequest() {
    }

    public UserSetUserPasswordRequest(String verificationCode, String msgType, String userId, String password) throws Exception {
        this.verificationCode = verificationCode;
        this.msgType = msgType;
        this.userId = userId;
        this.password = password;
        this.passwordEncrypt = AES.encrypt(password);
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("verificationCode", this.verificationCode);
        txtParams.put("msgType", this.msgType);
        txtParams.put("userId", this.userId);
        txtParams.put("password", this.passwordEncrypt);
        return txtParams;
    }

    @Override
    public Class<UserSetUserPasswordResponse> getResponseClass() {
        return UserSetUserPasswordResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.verificationCode, "verificationCode");
        RuleCheckUtils.checkNotEmpty(this.msgType, "msgType");
        RuleCheckUtils.checkNotEmpty(this.userId, "userId");
        RuleCheckUtils.checkNotEmpty(this.password, "password");
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword(){
        return password;

    }

    public void setPassword(String password) throws Exception {
        this.password = password;
        this.passwordEncrypt = AES.encrypt(password);
    }
}
