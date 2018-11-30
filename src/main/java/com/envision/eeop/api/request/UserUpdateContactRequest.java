package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserUpdateContactResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/21.
 */
public class UserUpdateContactRequest implements EnvisionRequest<UserUpdateContactResponse> {
    private static final String API_METHOD = "/userService/updateContact";
    /** add user contact Stp2 */
    public static final String STP1 = "step1";
    /** add user contact Stp2 */
    public static final String STP2 = "step2";
    /** add user contact Stp3 */
    public static final String STP3 = "step3";

    private String email;
    private String areaCode;
    private String mobile;
    private String step;
    private String verificationCode;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("email", this.email);
        txtParams.put("areaCode", this.areaCode);
        txtParams.put("mobile", this.mobile);
        txtParams.put("verificationCode", this.verificationCode);
        txtParams.put("step", this.step);
        return txtParams;
    }

    @Override
    public Class<UserUpdateContactResponse> getResponseClass() {
        return UserUpdateContactResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.step, "step" );
        switch (this.step){
            case STP1 :
                RuleCheckUtils.checkNotEmpty((this.email == null ? "" : this.email) + (this.mobile == null ? "" : this.mobile), "email or mobile" );
                break;
            case STP2 :
                RuleCheckUtils.checkNotEmpty(this.verificationCode, "verificationCode" );
                break;
            case STP3 :
                RuleCheckUtils.checkNotEmpty(this.verificationCode, "verificationCode" );
                break;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
