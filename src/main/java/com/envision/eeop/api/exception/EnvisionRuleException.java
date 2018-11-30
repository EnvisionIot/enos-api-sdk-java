package com.envision.eeop.api.exception;

/*
 * Exception caused by violation of the rules 
 */
public class EnvisionRuleException extends EnvisionApiException {

	private static final long serialVersionUID = -7787145910600194272L;
	
	public EnvisionRuleException(String errCode, String errMsg) {
		super(errCode , errMsg);
	}
	
	public EnvisionRuleException(Throwable cause) {
		super(cause);
	}
}
