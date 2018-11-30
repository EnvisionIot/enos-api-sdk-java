package com.envisioniot.enos.enosapi.api.request.dataservice;

import com.envisioniot.enos.enosapi.common.response.EnOSResponse;

import java.lang.String;
import java.lang.Integer;

import com.envisioniot.enos.enosapi.common.annotation.*;
import com.envisioniot.enos.enosapi.common.enumeration.*;
import com.envisioniot.enos.enosapi.common.request.*;
import com.envisioniot.enos.enosapi.common.exception.*;

import java.util.*;

public class GetAssetsRawDataByTimeRangeRequest extends EnOSRequest<EnOSResponse> {
    private static final String API_METHOD = "/dataService/assets/rawData/timeRange";
    private static final String REQUEST_METHOD = "GET";

    private String orgId;

    private String modelId;

    private String assetIds;

    private String measurepoints;

    private String startTime;

    private String endTime;

    private Integer dataQuality;

    private Integer pageSize;

    private String pageToken;

    public GetAssetsRawDataByTimeRangeRequest(String orgId, String modelId, String assetIds, String measurepoints, String startTime, String endTime, Integer dataQuality, Integer pageSize, String pageToken) {
        this.orgId = orgId;
        this.modelId = modelId;
        this.assetIds = assetIds;
        this.measurepoints = measurepoints;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dataQuality = dataQuality;
        this.pageSize = pageSize;
        this.pageToken = pageToken;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public String getRequestMethod() {
        return REQUEST_METHOD;
    }

    @Override
    public void check() throws EnOSRuleException {
        // super.check();
    }
}