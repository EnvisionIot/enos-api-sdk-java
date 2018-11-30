package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;

/**
 * @author zhensheng.cai
 * @date 2018/10/22.
 */
public class DeviceCertApplyResultInfo implements Serializable{
    private static final long serialVersionUID = -7166547143918002053L;

    private String certChainURL;
    private String cert;
    private String certSN;

    public String getCertChainURL() {
        return certChainURL;
    }

    public void setCertChainURL(String certChainURL) {
        this.certChainURL = certChainURL;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getCertSN() {
        return certSN;
    }

    public void setCertSN(String certSN) {
        this.certSN = certSN;
    }
}
