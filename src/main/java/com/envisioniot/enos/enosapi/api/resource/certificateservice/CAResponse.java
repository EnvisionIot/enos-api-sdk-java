package com.envisioniot.enos.enosapi.api.resource.certificateservice;

import java.io.Serializable;

public class CAResponse implements Serializable {
    private static final long serialVersionUID = -5251953157445123183L;

    private int returnCode;
    private String errorMessage = null;
    private String issuedCert = null;
    private Integer issuedCertSN = null;

    // default constructor, don't delete it.
    public CAResponse() {
    }

    public boolean isSuccess() {
        return this.returnCode != -1;
    }

    public boolean isInternalError() {
        return this.errorMessage.equals("Internal error!");
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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
        return "CAResponse{" +
                "returnCode=" + returnCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", issuedCert='" + issuedCert + '\'' +
                ", issuedCertSN=" + issuedCertSN +
                '}';
    }
}
