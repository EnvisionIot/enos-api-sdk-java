package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserRegisterResponse;
import com.envision.eeop.api.util.AES;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserRegisterRequest implements EnvisionRequest<UserRegisterResponse> {
    public static final String STP1 = "step1";
    public static final String STP2 = "step2";

    public static final String SENDBY_EMAIL = "email";
    public static final String SENDBY_MOBILE = "mobile";

    private static final String API_METHOD = "/userService/register";
    private String step;
    private String verificationCode;
    private String orgCode;
    private String name;
    private String mobile;
    private String areaCode;
    private String email;
    private String password;
    private String sendBy;

    private String passwordEncrypt;

    public UserRegisterRequest() {
    }


    public UserRegisterRequest(String step, String verificationCode, String orgCode, String name, String mobile, String areaCode, String email, String password, String sendBy) {
        this.step = step;
        this.verificationCode = verificationCode;
        this.orgCode = orgCode;
        this.name = name;
        this.mobile = mobile;
        this.areaCode = areaCode;
        this.email = email;
        this.password = password;
        this.sendBy = sendBy;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("step", this.step);
        txtParams.put("sendBy", this.sendBy);
        txtParams.put("verificationCode", this.verificationCode);
        txtParams.put("orgCode", this.orgCode);
        txtParams.put("name", this.name);
        txtParams.put("mobile", this.mobile);
        txtParams.put("areaCode", this.areaCode);
        txtParams.put("email", this.email);
        txtParams.put("password", this.passwordEncrypt);


        return txtParams;
    }

    @Override
    public Class<UserRegisterResponse> getResponseClass() {
        return UserRegisterResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.step, "step");
        switch (this.step){
            case UserRegisterRequest.STP1 :
                RuleCheckUtils.checkNotEmpty((this.email == null ? "" : this.email) + (this.mobile == null ? "" : this.mobile), "email or mobile" );
                break;
            case UserRegisterRequest.STP2 :
                RuleCheckUtils.checkNotEmpty(this.verificationCode, "verificationCode");
                break;
            default:
                throw new EnvisionRuleException(RuleCheckUtils.ERROR_CODE_ARGUMENTS_INVALID,"step");
        }
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

    public void setPassword(String password) throws Exception {
        this.password = password;
        this.passwordEncrypt = AES.encrypt(password);
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }
}
