package com.envisioniot.enos.enosapi.sdk.client;

import com.envisioniot.enos.enosapi.common.request.EnOSRequest;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.common.exception.EnOSApiException;

/**
 * @Description: EnOS API Client
 */
public interface EnOSClient {

    /**
     * Implment Api Request
     *
     * @param <T>
     * @param request
     * @return
     * @throws EnOSApiException
     */
    public <T extends EnOSResponse> T execute(EnOSRequest<T> request) throws EnOSApiException;

    /**
     * Implment Api Request
     *
     * @param <T>
     * @param request
     * @return
     * @throws EnOSApiException
     */
    public <T extends EnOSResponse> T execute(EnOSRequest<T> request, Long requestTimestamp) throws EnOSApiException;

}