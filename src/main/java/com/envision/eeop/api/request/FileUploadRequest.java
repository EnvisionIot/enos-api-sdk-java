package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/10/18.
 */
public class FileUploadRequest implements EnvisionRequest<EnvisionResponse> {
    private static final String API_METHOD = "/fileService/upload";

    private String mdmId;

    private String timestamp;

    private File data;

    public String getMdmId() {
        return mdmId;
    }

    public void setMdmId(String mdmId) {
        this.mdmId = mdmId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }

    public FileUploadRequest(String mdmId, String timestamp, File data) {
        this.mdmId = mdmId;
        this.timestamp = timestamp;
        this.data = data;
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

    public Map<String, File> getFileParams() {
        Map<String, File> map = new HashMap<String, File>();

        map.put("data", data);

        return map;
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
