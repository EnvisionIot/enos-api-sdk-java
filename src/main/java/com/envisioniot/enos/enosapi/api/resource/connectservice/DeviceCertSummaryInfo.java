package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;

/**
 * @author zhensheng.cai
 * @date 2018/10/22.
 */
public class DeviceCertSummaryInfo implements Serializable {

    private static final long serialVersionUID = -8191159360752214420L;
    public static final int REVOKED = 1;
    public static final int ACTIVATED = 0;

    private String certSN;
    private int certStatus;

    public String getCertSN() {
        return certSN;
    }

    public void setCertSN(String certSN) {
        this.certSN = certSN;
    }

    public int getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(int certStatus) {
        this.certStatus = certStatus;
    }


}
