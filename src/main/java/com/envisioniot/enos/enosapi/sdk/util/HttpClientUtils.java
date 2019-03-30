package com.envisioniot.enos.enosapi.sdk.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

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
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {

            httpClient = getHttpClient();
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                response.close();
                return result;
            }
            return EMPTY_STR;
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                //连接池模式，不应该关闭
            }
        }
    }

    public static InputStream getInputStreamResult(HttpRequestBase request) throws IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = getHttpClient();
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            return entity.getContent();
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                //连接池模式，不应该关闭
            }
        }

    }

    public static HttpResponseResult getHttpResponseResult(HttpRequestBase request) throws IOException {
        return getHttpResponseResult(request, false);
    }

    /**
     * 如果是获取流信息，则待流信息关闭后再
     */
    public static HttpResponseResult getHttpResponseResult(HttpRequestBase request, boolean isStream) throws IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            httpClient = getHttpClient();
            response = httpClient.execute(request);
            int status = response.getStatusLine().getStatusCode();
            entity = response.getEntity();
            HttpResponseResult httpResponseResult = new HttpResponseResult(status, entity, isStream, response);
            return httpResponseResult;
        } finally {
            if (!isStream) {
                //释放entity资源
                EntityUtils.consume(entity);

                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    //连接池模式，不应该关闭
//                    httpClient.close();
                }
            }
        }
    }

    public static Charset getCharset(HttpEntity entity) {
        Charset charset = null;
        final ContentType contentType = ContentType.get(entity);
        if (contentType != null) {
            charset = contentType.getCharset();
        }
        if (charset == null) {
            charset = HTTP.DEF_CONTENT_CHARSET;
        }
        return charset;
    }

}