package com.envision.eeop.api;

import com.envision.eeop.api.exception.EnvisionApiException;

/**
 * This class implements a client to execute a request page-by-page
 * @author jieyuan.shen
 */
public class EnvisionDefaultPaginationClient extends EnvisionDefaultClient
{
    private int pageSize = 3000;
    
    // Execution Timeout(ms)
    private int executeTimeout = Integer.MAX_VALUE;
    
    // TODO: support parallism later
    
    public EnvisionDefaultPaginationClient(String serverUrl, String appKey, String appSecret)
    {
        super(serverUrl, appKey, appSecret);
    }

    public EnvisionDefaultPaginationClient(String serverUrl, String appKey, String appSecret, int pageSize)
    {
       super(serverUrl, appKey, appSecret);
        this.pageSize = pageSize;
    }

    public EnvisionDefaultPaginationClient(String serverUrl, String appKey, String appSecret, int pageSize, int executeTimeout)
    {
        super(serverUrl, appKey, appSecret);
        this.pageSize = pageSize;
        this.executeTimeout = executeTimeout;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends EnvisionResponse> T execute(EnvisionRequest<T> request) throws EnvisionApiException
    {
        if (request instanceof EnvisionPaginationRequest)
        {
            return (T) doPaginationRequest((EnvisionPaginationRequest<EnvisionPaginationResponse>) request, null);
        }
        else if (request instanceof EnvisionSkipAndLimitRequest)
        {
            return (T) doSkipAndLimitRequest((EnvisionSkipAndLimitRequest<EnvisionSkipAndLimitResponse>) request, null);
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
        else if (request instanceof EnvisionSkipAndLimitRequest)
        {
            return (T) doSkipAndLimitRequest((EnvisionSkipAndLimitRequest<EnvisionSkipAndLimitResponse>) request, token);
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
                throw new EnvisionApiException(request.getApiMethodName() + 
                        " failed at page no.: " + pageNo + ", page size: " + pageSize +
                        " , status: " + partialResponse.getStatus() + ", msg: " + 
                        partialResponse.getMsg() + " / " + partialResponse.getSubmsg());
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

    @SuppressWarnings("unchecked")
    private <T extends EnvisionSkipAndLimitResponse> T doSkipAndLimitRequest(EnvisionSkipAndLimitRequest<T> request, String token)
    throws EnvisionApiException
    {
        long startTime = System.currentTimeMillis();
        String exclusiveFrom = null;
        T response = null;
        T partialResponse;
        request.setPageSize(pageSize);
        do
        {
            request.setExclusiveFrom(exclusiveFrom);
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
                throw new EnvisionApiException(request.getApiMethodName() + " failed from: " + exclusiveFrom + ", page size: " + pageSize);
            }
            
            long currTime = System.currentTimeMillis();
            if (currTime - startTime > executeTimeout)
            {
                throw new EnvisionApiException(request.getApiMethodName() + " expired, limit: " + executeTimeout + ", actural: " + (currTime - startTime));
            }
            
            exclusiveFrom = partialResponse.getLastElement();
        } 
        while (!partialResponse.isLastPage() && exclusiveFrom != null);
        return response;
    }
}
