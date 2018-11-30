package com.envision.eeop.api.exception;

/*
 * Exception caused by violation of the rules 
 */
public class EnvisionIOException extends EnvisionApiException {

	private static final long serialVersionUID = -7787145910600194272L;
	
	public EnvisionIOException(String errCode, String errMsg) {
		super(errCode , errMsg);
	}
	
	public EnvisionIOException(Throwable cause) {
		super(cause);
	}
}
