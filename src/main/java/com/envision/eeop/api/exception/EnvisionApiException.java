package com.envision.eeop.api.exception;

/*
 * EEOP Root Exception
 */
public class EnvisionApiException extends Exception {

	private static final long serialVersionUID = -238091758285157331L;

	private String errCode;
	
	private String errMsg;

	public EnvisionApiException() {
		super();
	}

	public EnvisionApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public EnvisionApiException(String message) {
		super(message);
	}

	public EnvisionApiException(Throwable cause) {
		super(cause);
	}

	public EnvisionApiException(String errCode, String errMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public String getErrMsg() {
		return this.errMsg;
	}

}
