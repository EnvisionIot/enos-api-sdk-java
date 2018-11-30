package com.envision.eeop.api;

import java.util.Map;

import com.envision.eeop.api.exception.EnvisionRuleException;


/**
 * Client Request
 *
 * @param <T>
 */
public interface EnvisionRequest<T extends EnvisionResponse> {

	/**
	 * Get Api Name。
	 * 
	 * @return api Name
	 */
	public String getApiMethodName();

	/**
	 * Gets all the Key-Value form of the text request parameter set:
	 * <ul>
	 * <li>Key: Request parameter name</li>
	 * <li>Value: Request parameter value</li>
	 * </ul>
	 * 
	 * @return Text request parameter set
	 */
	public Map<String, String> getTextParams();

	/*
	 * Get Response Class
	 */
	public Class<T> getResponseClass();

	/*
	 * check request
	 */
	public void check() throws EnvisionRuleException;
}
