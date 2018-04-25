package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class SampleDataGetResponse extends EnvisionResponse {
    private static final long serialVersionUID = -8853413178471799929L;

    @SerializedName("next_offset")
    private String nextOffset;

    @SerializedName("result")
    private List<Map<String, String>> result;

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
    }

    public List<Map<String, String>> getResult() {
        return result;
    }

    public void setResult(List<Map<String, String>> result) {
        this.result = result;
    }
}
