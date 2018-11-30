package com.envisioniot.enos.enosapi.sdk.util;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * created by dongdong.wang
 */
public class HttpResponseResult {

    private int status;
    private HttpEntity entity;
    private boolean isRead = false;

    public HttpResponseResult() {
    }

    public HttpResponseResult(int status, HttpEntity entity) {
        this.status = status;
        this.entity = entity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public InputStream getInputStreamResult() {
        if(isRead) {
            return null;
        }
        try {
            isRead = true;
            return entity.getContent();
        } catch (IOException e) {
            return null;
        }
    }

    public String getStringResult() {
        if(isRead) {
            return null;
        }
        try {
            isRead = true;
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            return null;
        }
    }

    public void setEntity(HttpEntity entity) {
        this.entity = entity;
    }


}
