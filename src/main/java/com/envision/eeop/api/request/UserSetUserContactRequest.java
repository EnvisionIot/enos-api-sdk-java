package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserSetUserContactResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserSetUserContactRequest implements EnvisionRequest<UserSetUserContactResponse> {
    private static final String API_METHOD = "/userService/setUserContact";
    private String msgType;
    private String verificationCode;
    private String userId;
    private String mobile;
    private String areaCode;
    private String email;

    public UserSetUserContactRequest() {
    }

    public UserSetUserContactRequest(String msgType, String verificationCode, String userId, String mobile, String areaCode, String email) {
        this.msgType = msgType;
        this.verificationCode = verificationCode;
        this.userId = userId;
        this.mobile = mobile;
        this.areaCode = areaCode;
        this.email = email;
    }
    public UserSetUserContactRequest(String msgType, String verificationCode, String userId, String email) {
        this.msgType = msgType;
        this.verificationCode = verificationCode;
        this.userId = userId;
        this.email = email;
    }
    public UserSetUserContactRequest(String msgType, String verificationCode, String userId, String mobile, String areaCode) {
        this.msgType = msgType;
        this.verificationCode = verificationCode;
        this.userId = userId;
        this.mobile = mobile;
        this.areaCode = areaCode;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("msgType", this.msgType);
        txtParams.put("verificationCode", this.verificationCode);
        txtParams.put("userId", this.userId);
        txtParams.put("mobile", this.mobile);
        txtParams.put("areaCode", this.areaCode);
        txtParams.put("email", this.email);
        return txtParams;
    }

    @Override
    public Class getResponseClass() {
        return UserSetUserContactResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.userId, "userId");
        RuleCheckUtils.checkNotEmpty(this.msgType, "msgType");
        RuleCheckUtils.checkNotEmpty(this.verificationCode, "verificationCode");
        RuleCheckUtils.checkNotEmpty((this.email == null ? "" : this.email) + (this.mobile == null ? "" : this.mobile), "email or mobile" );
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
