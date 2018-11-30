package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zhiqi.yang on 2017/3/13.
 */
public class OAuthAuthorizeResponse extends EnvisionResponse {
    private static final long serialVersionUID = -5590069275277916228L;

    @SerializedName("code")
    private String code;

    @SerializedName("redirect_uri")
    private String redirect_uri;

    @SerializedName("state")
    private String state;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
