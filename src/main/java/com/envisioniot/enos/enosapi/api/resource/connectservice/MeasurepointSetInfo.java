package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;

/**
 * @author zhensheng.cai
 * @date 2018/9/14.
 */
public class MeasurepointSetInfo implements Serializable
{

    private static final long serialVersionUID = -5744234726161122482L;
    public String messageId;
    public String productKey;
    public String deviceKey;
    public String assetId;
    public Object inputData;
    public long gmtDeviceReply;

    public MeasurepointSetInfo() {
    }

    public MeasurepointSetInfo(String messageId, String productKey, String deviceKey, String assetId, Object inputData,
                               long gmtDeviceReply)
    {
        this.messageId = messageId;
        this.productKey = productKey;
        this.deviceKey = deviceKey;
        this.assetId = assetId;
        this.inputData = inputData;
        this.gmtDeviceReply = gmtDeviceReply;
    }


    public String getMessageId() {
        return messageId;
    }

    public MeasurepointSetInfo setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getProductKey() {
        return productKey;
    }

    public MeasurepointSetInfo setProductKey(String productKey) {
        this.productKey = productKey;
        return this;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public MeasurepointSetInfo setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
        return this;
    }

    public String getAssetId() {
        return assetId;
    }

    public MeasurepointSetInfo setAssetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    public Object getInputData() {
        return inputData;
    }

    public MeasurepointSetInfo setInputData(Object inputData) {
        this.inputData = inputData;
        return this;
    }

    public long getGmtDeviceReply() {
        return gmtDeviceReply;
    }

    public MeasurepointSetInfo setGmtDeviceReply(long gmtDeviceReply) {
        this.gmtDeviceReply = gmtDeviceReply;
        return this;
    }
}
