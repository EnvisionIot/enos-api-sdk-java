package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.ImportRunGetResponse;
import com.envision.eeop.api.response.ImportStartGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class ImportRunGetRequest implements EnvisionRequest<ImportRunGetResponse> {
    private static final String API_METHOD = "/importService/runTask";

    private String taskId;

    private String data;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public ImportRunGetRequest() {
    }

    public ImportRunGetRequest(String taskId, String data) {
        this.taskId = taskId;
        this.data = data;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("taskId", taskId);
        txtParams.put("data", data);

        return txtParams;
    }

    public Class<ImportRunGetResponse> getResponseClass() {
        return ImportRunGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(taskId, "taskId");
        RuleCheckUtils.checkNotNull(data, "data");
    }
}
