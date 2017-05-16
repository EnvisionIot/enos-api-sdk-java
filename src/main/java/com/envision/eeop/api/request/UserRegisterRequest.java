package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserRegisterResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserRegisterRequest implements EnvisionRequest<UserRegisterResponse> {


    private static final String API_METHOD = "/userService/register";
    private String msgType;
    private String verificationCode;
    private String orgCode;
    private String name;
    private String mobile;
    private String areaCode;
    private String email;
    private String password;

    public UserRegisterRequest() {
    }

    /**
     * register by mobile
     *
     * @param msgType
     * @param code
     * @param orgCode
     * @param name
     * @param mobile
     * @param areaCode
     * @param password
     */
    public UserRegisterRequest(String msgType, String verificationCode, String orgCode, String name, String mobile, String areaCode, String password) {
        this.msgType = msgType;
        this.verificationCode = verificationCode;
        this.orgCode = orgCode;
        this.name = name;
        this.mobile = mobile;
        this.areaCode = areaCode;
        this.password = password;
    }

    /**
     * register by email
     *
     * @param msgType
     * @param verificationCode
     * @param orgCode
     * @param name
     * @param email
     * @param password
     */
    public UserRegisterRequest(String msgType, String verificationCode, String orgCode, String name, String email, String password) {
        this.msgType = msgType;
        this.verificationCode = verificationCode;
        this.orgCode = orgCode;
        this.name = name;
        this.email = email;
        this.password = password;
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
        txtParams.put("orgCode", this.orgCode);
        txtParams.put("name", this.name);
        txtParams.put("mobile", this.mobile);
        txtParams.put("areaCode", this.areaCode);
        txtParams.put("email", this.email);
        txtParams.put("password", this.password);


        return txtParams;
    }

    @Override
    public Class getResponseClass() {
        return UserRegisterResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.name, "name");
        RuleCheckUtils.checkNotEmpty(this.msgType, "msgType");
        RuleCheckUtils.checkNotEmpty(this.verificationCode, "code");
        RuleCheckUtils.checkNotEmpty(this.orgCode, "orgCode");
        RuleCheckUtils.checkNotEmpty(this.password, "password");
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
