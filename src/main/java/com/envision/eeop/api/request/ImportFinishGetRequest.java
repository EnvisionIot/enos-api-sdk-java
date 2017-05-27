package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.ImportFinishGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class ImportFinishGetRequest implements EnvisionRequest<ImportFinishGetResponse> {
    private static final String API_METHOD = "/importService/finishTask";

    private String taskId;

    private String attr;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public ImportFinishGetRequest() {
    }

    public ImportFinishGetRequest(String taskId, String attr) {
        this.taskId = taskId;
        this.attr = attr;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("taskId", taskId);
        txtParams.put("attr", attr);

        return txtParams;
    }

    public Class<ImportFinishGetResponse> getResponseClass() {
        return ImportFinishGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotNull(taskId, "taskId");
        RuleCheckUtils.checkNotNull(attr, "attr");
    }
}
