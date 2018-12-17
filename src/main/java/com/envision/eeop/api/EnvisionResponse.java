package com.envision.eeop.api;

import java.io.Serializable;


/**
 * Client Response
 *
 */
public class EnvisionResponse implements Serializable {
	private static final long serialVersionUID = -8822133856840363264L;

	private String requestId;

	protected int status;

	protected String msg;
	
	protected String submsg;
	
	protected String body;
	
	public EnvisionResponse(){
		
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isSuccess() {
		return this.status == 0 ? true : false;
	}

	public String getSubmsg() {
		return submsg;
	}

	public void setSubmsg(String submsg) {
		this.submsg = submsg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
