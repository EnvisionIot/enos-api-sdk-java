package com.envisioniot.enos.enosapi.sdk.client;

import com.envisioniot.enos.enosapi.common.enumeration.TransferType;
import com.envisioniot.enos.enosapi.common.exception.EnOSApiException;
import com.envisioniot.enos.enosapi.common.exception.EnOSClientException;
import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.resource.EnOSTransferFileInfo;
import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.common.util.*;
import com.envisioniot.enos.enosapi.sdk.enums.SignMethods;
import com.envisioniot.enos.enosapi.sdk.util.HttpResponseResult;
import com.envisioniot.enos.enosapi.sdk.util.JacksonUtil;
import com.envisioniot.enos.enosapi.sdk.util.Sign;
import com.envisioniot.enos.enosapi.sdk.util.WebUtils;
import com.google.common.base.Strings;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EnOSDefaultClient implements EnOSClient {
    private static Logger logger = LoggerFactory.getLogger(EnOSDefaultClient.class);

    private String serverUrl;

    private String accessKey;

    private String secretKey;

    private int connectTimeout = 30000;

    private int readTimeout = 30000;

    private SignMethods signMethod = SignMethods.SHA_256;


    /**
     * @param serverUrl
     * @param accessKey
     * @param secretKey
     */
    public EnOSDefaultClient(String serverUrl, String accessKey, String secretKey) {
        super();
        this.serverUrl = serverUrl;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * @param serverUrl
     * @param accessKey
     * @param secretKey
     * @param connectTimeout
     * @param readTimeout
     */
    public EnOSDefaultClient(String serverUrl, String accessKey, String secretKey, int connectTimeout,
                             int readTimeout) {
        super();
        this.serverUrl = serverUrl;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    public void setSignMethod(SignMethods signMethod) {
        this.signMethod = signMethod;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public <T extends EnOSResponse> T execute(EnOSRequest<T> request) throws EnOSApiException {
        return doExecute(request, null);
    }

    @Override
    public <T extends EnOSResponse> T execute(EnOSRequest<T> request, Long requestTimestamp)
            throws EnOSApiException {
        return doExecute(request, requestTimestamp);
    }

    protected <T extends EnOSResponse> T doExecute(EnOSRequest<T> request, Long requestTimestamp)
            throws EnOSApiException {
        T response = null;
        try {
            request.check();
            response = doRequest(request, requestTimestamp);
        } catch (EnOSClientException e) {
            EnOSErrorCode errorCode = e.getEnosStatus();
            String subMsg = EnOSErrorCode.CLIENT_ERROR.getMsg();
            if (e.getErrMsg() != null) {
                subMsg = subMsg + ": " + e.getErrMsg();
            }
            if (errorCode == null) {
                errorCode = EnOSErrorCode.CLIENT_ERROR;
            }
            logger.error(subMsg);
            response = (T) new EnOSResponse<>();
            response.setStatus(errorCode.getCode());
            response.setMsg(errorCode.getMsg());
            response.setSubmsg(subMsg);
        }
        logger.info("result:" + JsonParser.toJson(response));
        return response;
    }

    private <T extends EnOSResponse> T doRequest(EnOSRequest<T> request, Long requestTimestamp)
            throws EnOSClientException {
        Map<String, String> textParams = request.getUrlParams();
        String jsonParam = request.getJsonParam();
        if (requestTimestamp == null) {
            requestTimestamp = System.currentTimeMillis();
        }
        textParams.put(Constants.REQUEST_TIMESTAMP, requestTimestamp.toString());
        String url = makeUrl(request.getApiPath(), textParams, jsonParam);

        //包含文件传输，字节流传输
        List<EnOSTransferFileInfo> transferFileInfos = request.getTransferFiles();
        Map<String, List<File>> uploadFiles = new HashMap<>();
        File downloadFile = null;
        int downloadFileCount = 0;
        for (EnOSTransferFileInfo fileInfo : transferFileInfos) {
            if (fileInfo.getTransferType().equals(TransferType.DOWNLOAD)) {
                downloadFileCount++;
                downloadFile = fileInfo.getFile();
                if (downloadFileCount > 1) {
                    throw new EnOSClientException(EnOSErrorCode.CLIENT_ERROR, "only support single file download");
                }
            } else {
                if (fileInfo.getFile() != null) {
                    List<File> subUploadFiles = uploadFiles.get(fileInfo.getTransferName());
                    if (subUploadFiles == null) {
                        subUploadFiles = new ArrayList<>();
                        uploadFiles.put(fileInfo.getTransferName(), subUploadFiles);
                    }
                    subUploadFiles.add(fileInfo.getFile());
                }
            }
        }
        HttpResponseResult httpResponse = null;
        try {
            HttpRequestBase httpRequest = null;
            if (!request.hasFileUpload()) {
                //无文件传输
                httpRequest = WebUtils.getFilledHttpRequest(url, textParams, null, jsonParam, null, WebUtils.DEFAULT_CHARSET, request.getRequestMethod(), connectTimeout, readTimeout);
            } else {
                //包含文件传输
                httpRequest = WebUtils.getFilledHttpRequestWithFileUpload(url, textParams, null, uploadFiles, WebUtils.DEFAULT_CHARSET, request.getRequestMethod(), this.connectTimeout, this.readTimeout);

            }
            boolean isStream = (downloadFile != null);
            httpResponse = WebUtils.getHttpResponseResult(httpRequest, isStream);

            //文件下载后续处理，将文件内容写入下载文件
            if (downloadFile != null && isStream) {
                EnOSResponse response = new EnOSResponse();
                int httpCode = httpResponse.getStatus();
                if (httpCode == HttpStatus.SC_OK) {
                    InputStream responseStream = httpResponse.getInputStreamResult();
                    FileUtil.writeFileAsStream(downloadFile.getAbsolutePath(), responseStream);
                } else {
                    String strErr = httpResponse.getStringResult();
                    response.setMsg(strErr);
                }
                response.setStatus(httpCode);
                return (T) response;

            } else {
                String strResponse = httpResponse.getStringResult();
                T response = JacksonUtil.fromJson(strResponse, request.getResponseType());
                return response;
            }

        } catch (IOException e) {
            logger.error("Execute Post Request Failed!", e);
            throw new EnOSClientException(e);
        } finally {
            if (httpResponse != null) {
                httpResponse.releaseIfIsStream();
            }
        }
    }

    private String makeUrl(String apiName, Map<String, String> textParams, String bodyContent) throws EnOSClientException {
        // Add sign
        String sign = Sign.sign(accessKey, secretKey, textParams, bodyContent, signMethod.getAlgorithm());
        if(Strings.isNullOrEmpty(sign)) {
            throw new EnOSClientException(EnOSErrorCode.APP_SIGN_FAIL);
        }

        // Build Url
        StringBuilder url = new StringBuilder(serverUrl);

        // Make Url
        url.append(apiName);
        url.append("?");
        url.append("accessKey=");
        url.append(accessKey);
        url.append("&sign=");
        url.append(sign);

        return url.toString();
    }
}
