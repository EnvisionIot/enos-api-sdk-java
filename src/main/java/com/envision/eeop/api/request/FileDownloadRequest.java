package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/10/18.
 */
public class FileDownloadRequest extends AbstractEnvisionStreamRequest {
    private static final String API_METHOD = "/fileService/download";

    private String mdmId;

    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMdmId() {
        return mdmId;
    }

    public void setMdmId(String mdmId) {
        this.mdmId = mdmId;
    }

    public FileDownloadRequest(String mdmId, String timestamp, File file) {
        this.mdmId = mdmId;
        this.timestamp = timestamp;
        this.file = file;
    }

    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        Map<String, String> txtParams = new HashMap<String, String>();

        txtParams.put("mdmid", mdmId);
        txtParams.put("timestamp", timestamp);

        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass() {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(mdmId, "mdmid");
        RuleCheckUtils.checkNotEmpty(timestamp, "timestamp");
        RuleCheckUtils.checkDateFormat(timestamp, "yyyyMMdd");
    }
}
