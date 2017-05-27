package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class ImportStartGetResponse extends EnvisionResponse {
    private static final long serialVersionUID = -3404113306837189188L;

    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
