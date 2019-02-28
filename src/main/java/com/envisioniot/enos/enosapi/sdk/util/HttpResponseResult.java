package com.envisioniot.enos.enosapi.sdk.util;

import com.envisioniot.enos.enosapi.common.util.StreamUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * created by dongdong.wang
 */
public class HttpResponseResult {

    private int status;
    private boolean isStream;
    private String strResponse;
    private InputStream inputStream;

    //realease resource if isStream
    CloseableHttpResponse httpResponse = null;
    HttpEntity entity = null;

    public HttpResponseResult(int status, HttpEntity entity, boolean isStream) throws IOException {
        this.status = status;
        this.isStream = isStream;
        if (isStream) {
            this.inputStream = entity.getContent();
        } else {
            strResponse = EntityUtils.toString(entity);
        }
    }

    public HttpResponseResult(int status, HttpEntity entity, boolean isStream, CloseableHttpResponse httpResponse) throws IOException {
        this(status, entity, isStream);
        if (isStream) {
            this.httpResponse = httpResponse;
            this.entity = entity;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public InputStream getInputStreamResult() {
        if (isStream) {
            return inputStream;
        }
        return null;
    }


    public String getStringResult() {
        if (!isStream) {
            return strResponse;
        } else {
            //将stream转换为string
            try {
                strResponse = StreamUtil.inputStreamToString(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return strResponse;
        }
    }

    public void releaseIfIsStream() {
        if (isStream) {
            try {
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (httpResponse != null) {
                try {
                    this.httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
