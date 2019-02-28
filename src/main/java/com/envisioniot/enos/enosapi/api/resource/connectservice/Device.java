package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;
import java.util.Map;

public class Device implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productKey;
    private String productName;
    private String deviceKey;
    private String deviceName;
    private String deviceSecret;
    private String deviceDesc;
    private String timezone;
    private Boolean isDST;
    private String assetId;
    private String topo;
    private String orgId;
    private String createBy;
    private Long gmtCreate;
    private Long gmtModified;
    private Long gmtActive;
    private Long gmtOnline;
    private Long gmtOffline;
    private String status;
    private Integer nodeType;
    private Map<String, Object> deviceAttributes;

    public Device() {
        this.productKey = null;
        this.deviceKey = null;
        this.deviceName = null;
        this.deviceSecret = null;
        this.assetId = null;
        this.nodeType = -1;
        this.gmtCreate = null;
        this.gmtModified = null;
        this.gmtActive = null;
        this.gmtOnline = null;
        this.gmtOnline = gmtOffline;
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

    public String getTimezone()
    {
        return timezone;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
    }

    public Boolean getIsDST()
    {
        return isDST;
    }

    public void setIsDST(Boolean isDST)
    {
        this.isDST = isDST;
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

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getGmtActive() {
        return gmtActive;
    }

    public void setGmtActive(Long gmtActive) {
        this.gmtActive = gmtActive;
    }

    public Long getGmtOnline() {
        return gmtOnline;
    }

    public void setGmtOnline(Long gmtOnline) {
        this.gmtOnline = gmtOnline;
    }

    public Long getGmtOffline() {
        return gmtOffline;
    }

    public void setGmtOffline(Long gmtOffline) {
        this.gmtOffline = gmtOffline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Map<String, Object> getDeviceAttributes() {
        return deviceAttributes;
    }

    public void setDeviceAttributes(Map<String, Object> deviceAttributes) {
        this.deviceAttributes = deviceAttributes;
    }

    @Override
    public String toString() {
        return "Device [productKey=" + this.productKey + ", productName=" + this.productName + ", deviceKey=" + this.deviceKey + ", deviceName=" + this.deviceName + ", deviceSecret=" + this.deviceSecret + ", assetId=" + this.assetId + ", gmtCreate=" + this.gmtCreate + ", gmtActive=" + this.gmtModified + ", gmtModified=" + this.gmtActive + ", gmtOnline=" + this.gmtOnline + ", gmtOffline=" + this.gmtOffline + ", status=" + this.status + ", nodeType=" + this.nodeType + ", deviceAttributes=" + this.deviceAttributes + "]";
    }


}
