package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.EventContent;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zuoyong.tang
 * @date 2018-05-14
 */
public class EventContentGetResponse extends EnvisionResponse{
    private static final long serialVersionUID = -3473865923832091909L;

    @SerializedName("data")
    private Map<String, List<EventContent>> data = new HashMap<>();

    public Map<String, List<EventContent>> getData() {
        return data;
    }

    public void setData(Map<String, List<EventContent>> data) {
        this.data = data;
    }
}
