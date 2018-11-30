package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zuoyong.tang on 2018/8/24.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -1949401688771583554L;

    public Product() {

    }

    private String productId;
    private String productName;
    private String productKey;
    private String productSecret;
    private String productDesc;
    private int dataType = 1 ;
    private int nodeType = 0;
    private int authType = 0;
    private Map<String, String> productTags;
    private String modelId;
    private Boolean dynamic = null;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getProductSecret() {
        return productSecret;
    }

    public void setProductSecret(String productSecret) {
        this.productSecret = productSecret;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public int getAuthType() {
        return authType;
    }

    public void setAuthType(int authType) {
        this.authType = authType;
    }

    public Map<String, String> getProductTags() {
        return productTags;
    }

    public void setProductTags(Map<String, String> productTags) {
        this.productTags = productTags;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Boolean getDynamic() {
        return dynamic;
    }

    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productKey='" + productKey + '\'' +
                ", productSecret='" + productSecret + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", dataType=" + dataType +
                ", nodeType=" + nodeType +
                ", authType=" + authType +
                ", productTags=" + productTags +
                ", modelId='" + modelId + '\'' +
                ", dynamic=" + dynamic +
                '}';
    }
}
