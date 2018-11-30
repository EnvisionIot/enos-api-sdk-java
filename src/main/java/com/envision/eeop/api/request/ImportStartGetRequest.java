package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.ImportStartGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class ImportStartGetRequest implements EnvisionRequest<ImportStartGetResponse> {
    private static final String API_METHOD = "/importService/startTask";

    private String customerId;

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public ImportStartGetRequest() {
    }

    public ImportStartGetRequest(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("customerId", customerId);

        return txtParams;
    }

    public Class<ImportStartGetResponse> getResponseClass() {
        return ImportStartGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
    }
}
