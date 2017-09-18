package com.envision.eeop.api.domain;

/**
 * Created by zhiqi.yang on 2017/5/21.
 */
public class UserContactVo extends UserInfoVo {
    private static final long serialVersionUID = -2688322305770566908L;
    private String step;
    private String verificationCode;
    private String sendBy;

    public UserContactVo() {
    }

    public UserContactVo(String verificationCode, String step, String email, String areaCode, String mobile){
        this.setVerificationCode(verificationCode);
        this.setStep(step);
        this.setEmail(email);
        this.setAreaCode(areaCode);
        this.setMobile(mobile);
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

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }
}
