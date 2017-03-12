package com.envision.eeop.api;

import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.request.FileDownloadRequest;
import com.envision.eeop.api.request.FileUploadRequest;
import com.envision.eeop.api.util.Sign;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/10/18.
 */
public class EnvisionDefaultStreamClient implements EnvisionStreamClient {
    @SuppressWarnings("unused")
    private static Logger logger = LoggerFactory
            .getLogger(EnvisionDefaultStreamClient.class);

    private String serverUrl;

    private String appKey;

    private String appSecret;

    /**
     * @param serverUrl
     * @param appKey
     * @param appSecret
     */
    public EnvisionDefaultStreamClient(String serverUrl, String appKey,
                                       String appSecret) {
        super();
        this.serverUrl = serverUrl;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public boolean download(FileDownloadRequest request, String token) throws EnvisionApiException, IOException {
        String url = makeUrl(request.getTextParams(), request.getApiMethodName());
        CloseableHttpClient client = HttpClients.createDefault();

        HttpResponse response = execute(client, url, null, request.getTextParams());

        if (response == null || response.getStatusLine().getStatusCode() != 200)
            return false;

        InputStream is = response.getEntity().getContent();
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(request.getResult()));
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = bis.read(b, 0, b.length)) != -1) {
            bos.write(b, 0, len);
        }
        bis.close();
        bos.close();
        client.close();

        return true;
    }

    public boolean upload(FileUploadRequest request, String token) throws EnvisionApiException, IOException {
        String url = makeUrl(request.getTextParams(), request.getApiMethodName());
        CloseableHttpClient client = HttpClients.createDefault();

        HttpResponse response = execute(client, url, request.getFileParams(), request.getTextParams());

        if (response == null || response.getStatusLine().getStatusCode() != 200)
            return false;

        return true;
    }

    private HttpResponse execute(CloseableHttpClient client, String url, Map<String, File> fileBodys, Map<String, String> stringBodys) throws IOException {
        HttpPost post = new HttpPost(url);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        if (fileBodys != null) {
            for (String key : fileBodys.keySet()) {
                FileBody fileBody = new FileBody(fileBodys.get(key), ContentType.DEFAULT_BINARY);
                builder.addPart(key, fileBody);
            }
        }
        if (stringBodys != null) {
            for (String key : stringBodys.keySet()) {
                StringBody stringBody = new StringBody(stringBodys.get(key), ContentType.APPLICATION_FORM_URLENCODED);
                builder.addPart(key, stringBody);
            }
        }

        HttpEntity entity = builder.build();
        post.setEntity(entity);

        HttpResponse response = client.execute(post);

        return response;
    }

    private String makeUrl(Map<String, String> textParams, String apiName) {
        // Add sign
        String sign = Sign.sign(appKey, appSecret, textParams);

        // Build Url
        StringBuilder url = new StringBuilder(serverUrl);

        // Make Url
        url.append(apiName);
        url.append("?");
        url.append("appKey=");
        url.append(appKey);
        url.append("&sign=");
        url.append(sign);

        return url.toString();
    }

}
