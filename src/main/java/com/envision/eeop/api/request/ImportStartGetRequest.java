package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import com.envision.eeop.api.response.ImportStartGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class ImportStartGetRequest implements EnvisionRequest<ImportStartGetResponse> {
    private static final String API_METHOD = "/importService/startTask";

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    public ImportStartGetRequest() {
    }

    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        return txtParams;
    }

    public Class<ImportStartGetResponse> getResponseClass() {
        return ImportStartGetResponse.class;
    }

    public void check() throws EnvisionRuleException {
    }
}
