package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DomainControlRequest implements EnvisionRequest<EnvisionResponse>
{
    private static final String API_METHOD = "/controlService/control";

    private String mdmid;                   // mandatory

    private Map<String,String> pointsJson;  // mandatory

    /**
     * construct a control request
     * @param pointsJson one or multiple control points and parameters
     */
    public DomainControlRequest(String mdmid, Map<String,String> pointsJson)
    {
        this.mdmid = mdmid;
        this.pointsJson = pointsJson;
    }

    /**
     * @param mdmID
     * @param point
     * @param parameter
     * @deprecated use {@link #DomainControlRequest(String, Map)} instead
     */
    public DomainControlRequest(String mdmid, String point)
    {
        this.mdmid = mdmid;
        this.pointsJson = new HashMap<>();
        this.pointsJson.put(point, "");
    }

    /**
     * @param mdmID
     * @param point
     * @param parameter
     * @deprecated use {@link #DomainControlRequest(String, Map)} instead
     */
    public DomainControlRequest(String mdmid, String point, String parameter)
    {
        this.mdmid = mdmid;
        this.pointsJson = new HashMap<>();
        this.pointsJson.put(point, parameter);
    }

    @Override
    public String getApiMethodName()
    {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();

        txtParams.put("mdmid", mdmid);
        txtParams.put("points", 
                new Gson().toJson(pointsJson, new TypeToken<Map<String,String>>(){}.getType()));

        // TODO: to be removed in future release
        Entry<String,String> firstPoint = pointsJson.entrySet().iterator().next();
        txtParams.put("point", firstPoint.getKey());
        if (!StringUtils.isEmpty(firstPoint.getValue()))
        {
            txtParams.put("parameter", firstPoint.getValue());
        }

        return txtParams;
    }

    @Override
    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
        RuleCheckUtils.checkNotEmpty(pointsJson, "points");
    }
}
