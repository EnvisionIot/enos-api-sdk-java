package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionPaginationRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DimensionsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.google.gson.GsonBuilder;

import java.util.Map;

/**
 * Dimension Find by Columns, supporting pagination
 */
public class DimensionFindByColumnsRequest extends EnvisionPaginationRequest<DimensionsGetResponse>
{
    private static final String API_METHOD = "/dimension/findByColumns";

    private String mdmid; // mandatory

    private String table; // mandatory

    private String columnFilters;

    /**
     * @param mdmid
     * @param table
     * @param columns
     */
    public DimensionFindByColumnsRequest(String mdmid, String table, Map<String, Object> columns)
    {
        super();
        this.mdmid = mdmid;
        this.table = table;
        // null is a valid filter value
        columnFilters = new GsonBuilder().serializeNulls().create().toJson(columns);
    }
    
    public DimensionFindByColumnsRequest(String mdmid, String table, Map<String, Object> columns, int pageNo, int pageSize)
    {
        this(mdmid, table, columns);
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    public String getMdmid()
    {
        return mdmid;
    }

    public void setMdmid(String mdmid)
    {
        this.mdmid = mdmid;
    }

    public String getTable()
    {
        return table;
    }

    public void setTable(String table)
    {
        this.table = table;
    }

    public String getColumnFilters()
    {
        return columnFilters;
    }

    public void setColumnFilters(String columnFilters)
    {
        this.columnFilters = columnFilters;
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
        txtParams.put("table", table);
        txtParams.put("columnFilters", columnFilters);
        txtParams.putAll(getPaginationParams());

        return txtParams;
    }

    @Override
    public Class<DimensionsGetResponse> getResponseClass()
    {
        return DimensionsGetResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException
    {
        super.check();
        RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
        RuleCheckUtils.checkNotEmpty(table, "table");
        RuleCheckUtils.checkNotEmpty(columnFilters, "columnFilters");
    }
}
