package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.EventTypeTree;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zuoyong.tang
 * @date 2018-05-14
 */
public class EventTypeGetResponse extends EnvisionResponse{
    private static final long serialVersionUID = -7884902260970051351L;

    @SerializedName("data")
    private Map<String, List<EventTypeTree>> data = new HashMap<>();

    public Map<String, List<EventTypeTree>> getData() {
        return data;
    }

    public void setData(Map<String, List<EventTypeTree>> data) {
        this.data = data;
    }
}
