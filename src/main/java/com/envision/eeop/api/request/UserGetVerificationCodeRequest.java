package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserGetVerificationCodeResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/5.
 */
public class UserGetVerificationCodeRequest implements EnvisionRequest<UserGetVerificationCodeResponse> {
    /** type : register */
    public static final String TYPE_REGISTER = "register";
    /** type : modify user contact Stp1 */
    public static final String TYPE_MODIFY_CONTACT_STP1 = "modifyUserContactStp1";
    /** type : modify user contact Stp2 */
    public static final String TYPE_MODIFY_CONTACT_STP2 = "modifyUserContactStp2";
    /** type : modify password */
    public static final String TYPE_MODIFYPASSWORD_EMAIL = "modifyPasswordByEmail";
    public static final String TYPE_MODIFYPASSWORD_MOBILE = "modifyPasswordByMobile";

    private String email;
    private String areaCode;
    private String mobile;
    private String type;
    private String userId;
    private String verificationCode;
    private static final String API_METHOD = "/userService/getVerificationCode";



    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        if (null != this.email && this.email.trim().length() > 0){
            txtParams.put("email", this.email);
        } else {
            txtParams.put("areaCode", this.areaCode);
            txtParams.put("mobile", this.mobile);
        }
        txtParams.put("type", this.type);
        txtParams.put("userId", this.userId);
        if (this.verificationCode != null){
            txtParams.put("verificationCode", this.verificationCode);
        }
        return txtParams;
    }

    @Override
    public Class getResponseClass() {
        return UserGetVerificationCodeResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        if (TYPE_MODIFY_CONTACT_STP1.equals(this.type)
                || TYPE_MODIFYPASSWORD_EMAIL.equals(this.type)
                || TYPE_MODIFYPASSWORD_MOBILE.equals(this.type)){
            RuleCheckUtils.checkNotEmpty(this.userId, "userId" );
        } else {
            RuleCheckUtils.checkNotEmpty((this.email == null ? "" : this.email) + (this.mobile == null ? "" : this.mobile), "email or mobile" );
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
