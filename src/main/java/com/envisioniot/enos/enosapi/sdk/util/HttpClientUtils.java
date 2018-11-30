package com.envisioniot.enos.enosapi.sdk.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
    private static PoolingHttpClientConnectionManager cm;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";

    private static void init() {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(2000); // 整个连接池最大连接数
            cm.setDefaultMaxPerRoute(500); // 每路由最大连接数，默认值是2
        }
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        init();
        return HttpClients.custom().setConnectionManager(cm).build();
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    public static String getResult(HttpRequestBase request) throws IOException {
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = httpClient.execute(request);
        // response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // long len = entity.getContentLength();// -1 表示长度未知
            String result = EntityUtils.toString(entity);
            response.close();
            // httpClient.close();
            return result;
        }

        return EMPTY_STR;
    }

    public static InputStream getInputStreamResult(HttpRequestBase request) throws IOException {
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = httpClient.execute(request);
        // response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        return entity.getContent();
    }

    public static HttpResponseResult getHttpResponseResult(HttpRequestBase request) throws IOException {
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = httpClient.execute(request);
        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        httpResponseResult.setStatus(status);
        httpResponseResult.setEntity(entity);
        return httpResponseResult;
    }

}