package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;

public class DeviceDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productKey;
    private String productName;
    private String deviceKey;
    private String deviceName;
    private String deviceSecret;
    private String deviceDesc;
    private String assetId;
    private String topo;
    private String orgId;
    private String createBy;
    private long gmtCreate;
    private long gmtActive;
    private long gmtOnline;
    private String status;
    private int nodeType;

    public DeviceDetail() {
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSecret() {
        return deviceSecret;
    }

    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getTopo() {
        return topo;
    }

    public void setTopo(String topo) {
        this.topo = topo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public long getGmtActive() {
        return gmtActive;
    }

    public void setGmtActive(long gmtActive) {
        this.gmtActive = gmtActive;
    }

    public long getGmtOnline() {
        return gmtOnline;
    }

    public void setGmtOnline(long gmtOnline) {
        this.gmtOnline = gmtOnline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public String toString() {
        return "DeviceDetail [productKey=" + this.productKey + ", productName=" + this.productName + ", deviceKey=" + this.deviceKey + ", deviceName=" + this.deviceName + ", deviceSecret=" + this.deviceSecret + ", assetId=" + this.assetId + ", gmtCreate=" + this.gmtCreate + ", gmtActive=" + this.gmtActive + ", gmtOnline=" + this.gmtOnline + ", status=" + this.status + ", nodeType=" + this.nodeType + "]";
    }

}
