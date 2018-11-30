package com.envisioniot.enos.enosapi.sdk.exception;

import com.envisioniot.enos.enosapi.common.exception.EnOSApiException;

/*
 * Exception caused by violation of the rules
 */
public class EnOSIOException extends EnOSApiException {

    private static final long serialVersionUID = -7787145910600194272L;

    public EnOSIOException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }

    public EnOSIOException(Throwable cause) {
        super(cause);
    }
}
