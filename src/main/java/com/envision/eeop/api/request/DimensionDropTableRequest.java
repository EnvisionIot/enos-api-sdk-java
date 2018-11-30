package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

/**
 * Drop a dimension table
 * @author jieyuan.shen
 */
public class DimensionDropTableRequest implements EnvisionRequest<EnvisionResponse>
{
    private static final String API_METHOD = "/dimension/dropTable";

    private String mdmID;           // mandatory
    private String table;           // mandatory
    
    public DimensionDropTableRequest(String mdmID, String table)  
    {
        this.mdmID = mdmID;
        this.table = table;
    }

    public String getMdmID()
    {
        return mdmID;
    }

    public void setMdmID(String mdmID)
    {
        this.mdmID = mdmID;
    }

    public String getTable()
    {
        return table;
    }

    public void setTable(String table)
    {
        this.table = table;
    }

    public String getApiMethodName()
    {
        return API_METHOD;
    }

    public Map<String, String> getTextParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("mdmid", mdmID);
        txtParams.put("table", table);
        return txtParams;
    }

    public Class<EnvisionResponse> getResponseClass()
    {
        return EnvisionResponse.class;
    }

    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkNotEmpty(mdmID, "mdmid");
        RuleCheckUtils.checkNotEmpty(table, "table");
    }
}
