package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AysnFileDownloadResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

public class AsynFileDownloadRequest implements EnvisionRequest<AysnFileDownloadResponse> {

    private static final String API_METHOD = "/fileService/download/request";
    private static final String DAILY_DATE_FORMAT = "yyyyMMdd";

    private String mdmId;
    private String tableName;
    private String columns;
    private String beginTime;
    private String endTime;
    private String fileName;
    private String callback;
    private String compress;

    public AsynFileDownloadRequest() {
    }

    public AsynFileDownloadRequest(String mdmId, String tableName, String columns, String beginTime, String endTime, String fileName) {
        this.mdmId = mdmId;
        this.tableName = tableName;
        this.columns = columns;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.fileName = fileName;
    }

    public AsynFileDownloadRequest(String mdmId, String tableName, String columns, String beginTime, String endTime, String fileName, String callback, String compress) {
        this.mdmId = mdmId;
        this.tableName = tableName;
        this.columns = columns;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.fileName = fileName;
        this.callback = callback;
        this.compress = compress;
    }

    public String getCompress() {
        return compress;
    }

    public void setCompress(String compress) {
        // default compress the file.
        if ("Y".equalsIgnoreCase(compress)) {
            this.compress = compress;
        } else {
            this.compress = "N";
        }
    }

    public String getMdmId() {
        return mdmId;
    }

    public void setMdmId(String mdmId) {
        this.mdmId = mdmId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {

        if (fileName == null || "".equals(fileName.trim())) {
            this.fileName = "file";
        } else {
            this.fileName = fileName;
        }
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }


    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmid", mdmId);
        txtParams.put("columns", columns);
        txtParams.put("end_time", endTime);
        txtParams.put("filename", fileName);
        txtParams.put("callback", callback);
        txtParams.put("tablename", tableName);
        txtParams.put("begin_time", beginTime);

        return txtParams;
    }

    @Override
    public Class<AysnFileDownloadResponse> getResponseClass() {
        return AysnFileDownloadResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(mdmId, "mdmid");
        RuleCheckUtils.checkNotEmpty(beginTime, "begintime");
        RuleCheckUtils.checkDateFormat(beginTime, DAILY_DATE_FORMAT);
        RuleCheckUtils.checkNotEmpty(endTime, "endtime");
        RuleCheckUtils.checkDateFormat(endTime, DAILY_DATE_FORMAT);
    }

}
