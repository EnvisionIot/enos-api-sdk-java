package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.ImportQueryGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class ImportQueryGetRequest implements EnvisionRequest<ImportQueryGetResponse> {
    private static final String API_METHOD = "/importService/queryProcess";

    private String taskId;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public ImportQueryGetRequest() {
    }

    public ImportQueryGetRequest(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("taskId", taskId);

        return txtParams;
    }

    public Class<ImportQueryGetResponse> getResponseClass() {
        return ImportQueryGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(taskId, "taskId");
    }
}
