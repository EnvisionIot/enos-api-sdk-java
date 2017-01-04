package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zhiqi.yang on 2016/12/29.
 */
public class PushSingleResponse extends EnvisionResponse {
    private static final long serialVersionUID = 8706594054628722129L;

    @SerializedName("messageId")
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
