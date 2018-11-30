package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AysnFileDownloadResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class AsynFileGenerateQueryRequest implements
        EnvisionRequest<AysnFileDownloadResponse> {

    private static final String API_METHOD = "/fileService/download/queryFileGenerated";

    private String id;

    private String mdmid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMdmid() {
        return mdmid;
    }

    public void setMdmid(String mdmid) {
        this.mdmid = mdmid;
    }

    public AsynFileGenerateQueryRequest() {

    }

    public AsynFileGenerateQueryRequest(String mdmid, String id) {
        this.id = id;
        this.mdmid = mdmid;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmid", mdmid);
        txtParams.put("id", id);

        return txtParams;
    }

    @Override
    public Class<AysnFileDownloadResponse> getResponseClass() {
        return AysnFileDownloadResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(id, "id");
        RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
    }

}
