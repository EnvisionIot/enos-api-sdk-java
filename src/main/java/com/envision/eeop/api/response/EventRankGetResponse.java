package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.EventRank;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zuoyong.tang
 * @date 2018-05-14
 */
public class EventRankGetResponse extends EnvisionResponse{
    private static final long serialVersionUID = 8979225201818866321L;

    @SerializedName("data")
    private Map<String, List<EventRank>> data = new HashMap<>();

    public Map<String, List<EventRank>> getData() {
        return data;
    }

    public void setData(Map<String, List<EventRank>> data) {
        this.data = data;
    }
}
