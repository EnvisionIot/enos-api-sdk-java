package com.envision.eeop.api;

import com.envision.eeop.api.exception.EnvisionApiException;

/**
 * This class implements a client to execute a request page-by-page
 * @author jieyuan.shen
 */
public class EnvisionDefaultSkipAndLimitClient extends EnvisionDefaultClient
{
    private int pageSize = 200;
    
    // Execution Timeout(ms)
    private int executeTimeout = 30000;
    
    // TODO: support parallism later
    
    public EnvisionDefaultSkipAndLimitClient(String serverUrl, String appKey, String appSecret)
    {
        super(serverUrl, appKey, appSecret);
    }

    public EnvisionDefaultSkipAndLimitClient(String serverUrl, String appKey, String appSecret, int pageSize)
    {
       super(serverUrl, appKey, appSecret);
        this.pageSize = pageSize;
    }

    public EnvisionDefaultSkipAndLimitClient(String serverUrl, String appKey, String appSecret, int pageSize, int executeTimeout)
    {
        super(serverUrl, appKey, appSecret);
        this.pageSize = pageSize;
        this.executeTimeout = executeTimeout;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends EnvisionResponse> T execute(EnvisionRequest<T> request) throws EnvisionApiException
    {
        if (request instanceof EnvisionSkipAndLimitRequest)
        {
            return (T) doPaginationRequest((EnvisionPaginationRequest<EnvisionPaginationResponse>) request, null);
        }
        else
        {
            throw new EnvisionApiException(request.getApiMethodName() + " does not support pagination.");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends EnvisionResponse> T execute(EnvisionRequest<T> request, String token) throws EnvisionApiException
    {
        if (request instanceof EnvisionPaginationRequest)
        {
            return (T) doPaginationRequest((EnvisionPaginationRequest<EnvisionPaginationResponse>) request, token);
        }
        else
        {
            throw new EnvisionApiException(request.getApiMethodName() + " does not support pagination.");
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends EnvisionPaginationResponse> T doPaginationRequest(EnvisionPaginationRequest<T> request, String token)
    throws EnvisionApiException
    {
        long startTime = System.currentTimeMillis();
        int pageNo = 0;
        T response = null;
        T partialResponse;
        request.setPageSize(pageSize);
        do
        {
            request.setPageNo(pageNo);
            partialResponse = super.doExecute(request, token);
            if (partialResponse.isSuccess())
            {
                if (response == null)
                {
                    response = partialResponse;
                }
                else
                {
                    response = (T) response.merge(partialResponse);
                }
            }
            else
            {
                throw new EnvisionApiException(request.getApiMethodName() + " failed at page no.: " + pageNo + ", page size: " + pageSize);
            }
            
            long currTime = System.currentTimeMillis();
            if (currTime - startTime > executeTimeout)
            {
                throw new EnvisionApiException(request.getApiMethodName() + " expired, limit: " + executeTimeout + ", actural: " + (currTime - startTime));
            }
            
            ++pageNo;
        } 
        while (!partialResponse.isLastPage());
        return response;
    }
}
