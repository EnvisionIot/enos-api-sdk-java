/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionPaginationResponse;
import com.google.gson.annotations.SerializedName;

public class DimensionsGetResponse extends EnvisionPaginationResponse
{

    private static final long serialVersionUID = 627716959003640263L;

    @SerializedName("data")
    private Map<String, Map<String, Object>> dimensionsMap;

    public Map<String, Map<String, Object>> getDimensions()
    {
        return dimensionsMap;
    }

    public void setDimensions(Map<String, Map<String, Object>> dimensionsMap)
    {
        this.dimensionsMap = dimensionsMap;
    }

    @Override
    public EnvisionPaginationResponse merge(EnvisionPaginationResponse another)
    {
        if (another.isSuccess() && 
            another instanceof DimensionsGetResponse)
        {
            dimensionsMap.putAll(((DimensionsGetResponse) another).dimensionsMap);
        }
        return this;
    }
}
