package com.envision.eeop.api;

import com.envision.eeop.api.exception.EnvisionApiException;


/**
 * EEOP Client
 * 
 * @author xiaomin.zhou
 */
public interface EnvisionClient {
	
	/**
	 * Implment Api Request
	 * 
	 * @param <T>
	 * @param request 
	 * @return
	 * @throws EnvisionApiException
	 */
	public <T extends EnvisionResponse> T execute(EnvisionRequest<T> request) throws EnvisionApiException;

	/**
	 * Implment Api Request
	 * 
	 * @param <T>
	 * @param request 
	 * @return
	 * @throws EnvisionApiException
	 */
	public <T extends EnvisionResponse> T execute(EnvisionRequest<T> request, String token) throws EnvisionApiException;


}
