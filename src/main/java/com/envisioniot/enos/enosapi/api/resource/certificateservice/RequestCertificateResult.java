package com.envisioniot.enos.enosapi.api.resource.certificateservice;

import java.io.Serializable;

public class RequestCertificateResult implements Serializable {
    private static final long serialVersionUID = -1061253877393204488L;

    private Integer approveStatus = null;
    private String issuedCert = null;
    private Integer issuedCertSN = null;

    // default constructor, don't delete it.
    public RequestCertificateResult() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getIssuedCert() {
        return issuedCert;
    }

    public void setIssuedCert(String issuedCert) {
        this.issuedCert = issuedCert;
    }

    public Integer getIssuedCertSN() {
        return issuedCertSN;
    }

    public void setIssuedCertSN(Integer issuedCertSN) {
        this.issuedCertSN = issuedCertSN;
    }

    @Override
    public String toString() {
        return "RequestCertificateResult{" +
                "approveStatus=" + approveStatus +
                ", issuedCert='" + issuedCert + '\'' +
                ", issuedCertSN=" + issuedCertSN +
                '}';
    }
}
