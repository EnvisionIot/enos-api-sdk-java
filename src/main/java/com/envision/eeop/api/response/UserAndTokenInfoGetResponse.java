package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.UserAndTokenInfo;
import com.google.gson.annotations.SerializedName;

/**
 * @author zuoyong.tang
 * @date 2018-05-14
 */
public class UserAndTokenInfoGetResponse extends EnvisionResponse{
    private static final long serialVersionUID = 7055003095039381983L;

    @SerializedName("data")
    private UserAndTokenInfo data;

    public UserAndTokenInfo getData() {
        return data;
    }

    public void setData(UserAndTokenInfo data) {
        this.data = data;
    }
}
