package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zhiqi.yang on 2017/5/5.
 */
public class UserGetVerificationCodeResponse extends EnvisionResponse {
    private static final long serialVersionUID = -3716929185643642002L;

    @SerializedName("sendBy")
    private String sendBy;

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }
}
