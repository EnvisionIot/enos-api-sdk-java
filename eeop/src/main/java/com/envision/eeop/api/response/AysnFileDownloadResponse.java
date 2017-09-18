package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

public class AysnFileDownloadResponse extends EnvisionResponse {

    /**
     *
     */
    private static final long serialVersionUID = -7930329895011432130L;

    @SerializedName("id")
    private String id;

    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
