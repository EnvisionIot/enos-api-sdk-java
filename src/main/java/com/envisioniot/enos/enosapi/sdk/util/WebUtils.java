package com.envisioniot.enos.enosapi.sdk.util;

import com.envisioniot.enos.enosapi.common.exception.EnOSClientException;
import com.envisioniot.enos.enosapi.common.resource.FileStreamInfo;
import com.envisioniot.enos.enosapi.common.util.Constants;
import com.envisioniot.enos.enosapi.common.util.EnOSErrorCode;
import com.envisioniot.enos.enosapi.common.util.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Web Utility
 */
public abstract class WebUtils {
    private static Logger logger = LoggerFactory.getLogger(WebUtils.class);

    public static final String DEFAULT_CHARSET = Constants.CHARSET_UTF8;
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String CONTENT_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE_APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";


    private WebUtils() {
    }

    public static HttpResponseResult doGet(String url, Map<String, String> params, int connectTimeout, int readTimeout)
            throws IOException, EnOSClientException {
        return doRequest(url, params, null, DEFAULT_CHARSET, METHOD_GET, connectTimeout, readTimeout);
    }

    public static HttpResponseResult doPost(String basicUrl, Map<String, String> urlParams, String bodyContent,
                                     int connectTimeout, int readTimeout) throws IOException, EnOSClientException {
        return doRequest(basicUrl, urlParams, bodyContent, DEFAULT_CHARSET, METHOD_POST, connectTimeout, readTimeout);
    }

    public static HttpResponseResult doPut(String basicUrl, Map<String, String> urlParams, String bodyContent,
                                    int connectTimeout, int readTimeout) throws IOException, EnOSClientException {
        return doRequest(basicUrl, urlParams, bodyContent, DEFAULT_CHARSET, METHOD_PUT, connectTimeout, readTimeout);
    }

    public static HttpResponseResult doDelete(String basicUrl, Map<String, String> urlParams, String bodyContent,
                                       int connectTimeout, int readTimeout) throws IOException, EnOSClientException {
        return doRequest(basicUrl, urlParams, bodyContent, DEFAULT_CHARSET, METHOD_DELETE, connectTimeout, readTimeout);
    }

    public static HttpResponseResult doRequest(String basicUrl, Map<String, String> urlParams, String bodyContent,
                                        String charset, String method, int connectTimeout, int readTimeout)
            throws IOException, EnOSClientException {

        // System.out.println("url & query & body: " + basicUrl + " & " + query + " & " + body);
        HttpRequestBase httpRequest =  getFilledHttpRequest(basicUrl, urlParams, null, bodyContent, null, charset, method, connectTimeout, readTimeout);
        boolean isStream = false;
        return getHttpResponseResult(httpRequest, isStream);
    }

    public static HttpResponseResult getHttpResponseResult(HttpRequestBase request, boolean isStream) throws IOException {
        HttpResponseResult rsp = null;
        try {
            rsp = HttpClientUtils.getHttpResponseResult(request, isStream);
        } catch (Exception e) {
            logger.error("", e);
            throw e;
        } finally {
        }
        return rsp;
    }

    private static URL buildGetUrl(String strUrl, String query)
            throws IOException {
        URL url = new URL(strUrl);
        if (StringUtils.isEmpty(query)) {
            return url;
        }

        if (StringUtils.isEmpty(url.getQuery())) {
            if (strUrl.endsWith("?")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "?" + query;
            }
        } else {
            if (strUrl.endsWith("&")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "&" + query;
            }
        }

        return new URL(strUrl);
    }

    public static String buildQuery(Map<String, String> params, String charset)
            throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        Set<Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtils.areNotEmpty(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=")
                        .append(URLEncoder.encode(value, charset));
            }
        }

        return query.toString();
    }

    private static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;

        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }

        return charset;
    }

    public static String decode(String value) {
        return decode(value, DEFAULT_CHARSET);
    }

    public static String encode(String value) {
        return encode(value, DEFAULT_CHARSET);
    }

    public static String decode(String value, String charset) {
        String result = null;
        if (!StringUtils.isEmpty(value)) {
            try {
                result = URLDecoder.decode(value, charset);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static String encode(String value, String charset) {
        String result = null;
        if (!StringUtils.isEmpty(value)) {
            try {
                result = URLEncoder.encode(value, charset);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    @SuppressWarnings("unused")
    private static Map<String, String> getParamsFromUrl(String url) {
        Map<String, String> map = null;
        if (url != null && url.indexOf('?') != -1) {
            map = splitUrlQuery(url.substring(url.indexOf('?') + 1));
        }
        if (map == null) {
            map = new HashMap<String, String>();
        }
        return map;
    }

    public static Map<String, String> splitUrlQuery(String query) {
        Map<String, String> result = new HashMap<String, String>();

        String[] pairs = query.split("&");
        if (pairs != null && pairs.length > 0) {
            for (String pair : pairs) {
                String[] param = pair.split("=", 2);
                if (param != null && param.length == 2) {
                    result.put(param[0], param[1]);
                }
            }
        }

        return result;
    }

    private static void setClientHeader(HttpRequestBase httpClient, String ctype) {
        httpClient.setHeader("Content-Type", ctype);
        httpClient.setHeader("Accept", "application/json");
    }

    /**
     * 发送 http post 请求，支持文件上传
     */
    public static HttpRequestBase getFilledHttpRequestWithFileUpload(String url, Map<String, String> urlParams, Map<String, String> formParams, Map<String, List<File>> uploadFiles, String charset, String requestMethod, int connectTimeout, int readTimeout) throws IOException, EnOSClientException {
        String query = buildQuery(urlParams, charset);
        URL parametricUrl = buildGetUrl(url, query);
        HttpRequestBase httpRequest = getHttpRequest(requestMethod);
        try {
            httpRequest.setURI(parametricUrl.toURI());
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout).setConnectTimeout(connectTimeout).build();
            httpRequest.setConfig(requestConfig);
            //        setClientHeader(httpPost, CONTENT_TYPE_MULTIPART_FORM_DATA);
        } catch (URISyntaxException e) {
            throw new EnOSClientException(e);
        }

        MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
        mEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        mEntityBuilder.setCharset(Charset.forName(charset));

        //文件上传,method=GET时无法上传文件
        ContentType fileContentType = ContentType.create(CONTENT_TYPE_MULTIPART_FORM_DATA, charset);//解决中文乱码
        if (httpRequest instanceof HttpEntityEnclosingRequestBase) {
            if (uploadFiles != null) {
                for (Entry<String, List<File>> entry : uploadFiles.entrySet()) {
                    List<File> fileList = entry.getValue();
                    for (File file : fileList) {
                        FileBody fileBody = new FileBody(file, fileContentType);
                        mEntityBuilder.addPart(entry.getKey(), fileBody);
                    }
                }
            }
            if (formParams != null) {
                for (Entry<String, String> formEntry : formParams.entrySet()) {
                    String field = formEntry.getKey();
                    String value = formEntry.getValue();
                    StringBody stringBody = new StringBody(value, fileContentType);
                    mEntityBuilder.addPart(field, stringBody);
                }
            }
            ((HttpEntityEnclosingRequestBase) httpRequest).setEntity(mEntityBuilder.build());
        }
        return httpRequest;
    }

    public static HttpRequestBase getFilledHttpRequest(String url, Map<String, String> urlParams, Map<String, String> formParams, String bodyContent, List<FileStreamInfo> fileStreams, String charset, String requestMethod, int connectTimeout, int readTimeout) throws IOException, EnOSClientException {
        if (bodyContent != null && formParams != null) {
            throw new EnOSClientException(EnOSErrorCode.CLIENT_ERROR, "bodyContent & formParams can not both be not null");
        }
        HttpRequestBase httpRequest = getHttpRequest(requestMethod);
        String formParamsQuery = null;
        if (fileStreams == null || fileStreams.isEmpty()) {
            String ctype = "application/json;charset=" + charset;
            setClientHeader(httpRequest, ctype);
        }

        String query = buildQuery(urlParams, charset);
        URL parametricUrl = buildGetUrl(url, query);

        try {
            logger.info("Do " + requestMethod + ", url & body: " + parametricUrl.toURI() + " & " + bodyContent);
            httpRequest.setURI(parametricUrl.toURI());
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout).setConnectTimeout(connectTimeout).build();
            httpRequest.setConfig(requestConfig);
            //        setClientHeader(httpPost, CONTENT_TYPE_MULTIPART_FORM_DATA);
        } catch (URISyntaxException e) {
            throw new EnOSClientException(e);
        }

        MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
        mEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        mEntityBuilder.setCharset(Charset.forName(charset));

        //文件上传,method=GET时无法上传文件
        ContentType fileContentType = ContentType.create(CONTENT_TYPE_MULTIPART_FORM_DATA, charset);//解决中文乱码
        if (httpRequest instanceof HttpEntityEnclosingRequestBase) {
            if (fileStreams != null || formParams != null) {
                if (fileStreams != null) {
                    for (FileStreamInfo fileStreamInfo : fileStreams) {
                        String field = fileStreamInfo.getFieldName();
                        String fileName = fileStreamInfo.getOriginalFileName();
                        InputStream fileContent = fileStreamInfo.getContent();
                        String contentType = fileStreamInfo.getContentType();
                        ContentBody streamBody = new InputStreamBody(fileContent, fileContentType, fileName);
                        mEntityBuilder.addPart(field, streamBody);
                    }
                }
                if (formParams != null) {
                    for (Entry<String, String> formEntry : formParams.entrySet()) {
                        String field = formEntry.getKey();
                        String value = formEntry.getValue();
                        StringBody stringBody = new StringBody(value, fileContentType);
                        mEntityBuilder.addPart(field, stringBody);
                    }
                }
                ((HttpEntityEnclosingRequestBase) httpRequest).setEntity(mEntityBuilder.build());
            } else if (bodyContent != null) {
                ((HttpEntityEnclosingRequestBase) httpRequest).setEntity(new StringEntity(bodyContent, charset));
            }
        }
        return httpRequest;
    }

    public static HttpRequestBase getHttpRequest(String requestMethod) {

        HttpRequestBase httpRequest;
        switch (requestMethod) {
            case "PUT":
                httpRequest = new HttpPut();
                break;
            case "DELETE":
                httpRequest = new HttpDeleteWithBody();
                break;
            case "GET":
                httpRequest = new HttpGet();
                break;
            case "POST":
            default:
                httpRequest = new HttpPost();
                break;
        }
        return httpRequest;
    }
}
