package com.envisioniot.enos.enosapi.api.resource.connectservice;

/**
 * Created by zuoyong.tang on 2018/9/10.
 */
public class ServiceInvokeInfo {
    private static final long serialVersionUID = -3230230628664204934L;

    private String requestId;
    private String messageId;
    private String requestMethod;
    private String callType;
    private String productKey;
    private String deviceKey;
    private String assetId;
    private String serviceName;
    private String serviceId;
    private String callbackUrl;
    private Object inputData;
    private Object outputData;
    private Long gmtServiceRequest;
    private Long gmtServiceReply;
    private Long gmtDeviceReply;

    public ServiceInvokeInfo() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Object getInputData() {
        return inputData;
    }

    public void setInputData(Object inputData) {
        this.inputData = inputData;
    }

    public Object getOutputData() {
        return outputData;
    }

    public void setOutputData(Object outputData) {
        this.outputData = outputData;
    }

    public Long getGmtServiceRequest() {
        return gmtServiceRequest;
    }

    public void setGmtServiceRequest(Long gmtServiceRequest) {
        this.gmtServiceRequest = gmtServiceRequest;
    }

    public Long getGmtServiceReply() {
        return gmtServiceReply;
    }

    public void setGmtServiceReply(Long gmtServiceReply) {
        this.gmtServiceReply = gmtServiceReply;
    }

    public Long getGmtDeviceReply() {
        return gmtDeviceReply;
    }

    public void setGmtDeviceReply(Long gmtDeviceReply) {
        this.gmtDeviceReply = gmtDeviceReply;
    }

    public String toString() {
        return "ServiceInvokeInfo{requestId=\'" + this.requestId + '\'' + ", messageId=\'" + this.messageId + '\'' + ", requestMethod=\'" + this.requestMethod + '\'' + ", callType=\'" + this.callType + '\'' + ", productKey=\'" + this.productKey + '\'' + ", deviceKey=\'" + this.deviceKey + '\'' + ", assetId=\'" + this.assetId + '\'' + ", serviceName=\'" + this.serviceName + '\'' + ", serviceId=\'" + this.serviceId + '\'' + ", callbackUrl=\'" + this.callbackUrl + '\'' + ", inputData=" + this.inputData + ", outputData=" + this.outputData + ", gmtServiceRequest=" + this.gmtServiceRequest + ", gmtServiceReply=" + this.gmtServiceReply + ", gmtDeviceReply=" + this.gmtDeviceReply + '}';
    }
}
