package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AsyncFileDownloadExecuteRequest extends AbstractEnvisionStreamRequest {
    private static final String API_METHOD = "/fileService/download/getFile";

    private String id;

    private String mdmid;

    public String getMdmid() {
        return mdmid;
    }

    public void setMdmid(String mdmid) {
        this.mdmid = mdmid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AsyncFileDownloadExecuteRequest() {

    }

    public AsyncFileDownloadExecuteRequest(String mdmid, String id, File file) {
        this.id = id;
        this.mdmid = mdmid;
        this.file = file;
    }

    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        Map<String, String> txtParams = new HashMap<String, String>();

        txtParams.put("id", id);
        txtParams.put("mdmid", mdmid);

        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass() {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(id, "id");
        RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
    }

}
