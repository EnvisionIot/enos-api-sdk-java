package com.envision.eeop.api;

import java.util.Map;

import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

/**
 * Client Limited Request
 * @param <T>   Response class type
 */
public abstract class EnvisionSkipAndLimitRequest<T extends EnvisionSkipAndLimitResponse>
implements EnvisionRequest<T>
{
    protected int pageSize = 0;       // optional

    protected String exclusiveFrom;        // optional

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getExclusiveFrom()
    {
        return exclusiveFrom;
    }

    public void setExclusiveFrom(String exclusiveFrom)
    {
        this.exclusiveFrom = exclusiveFrom;
    }

    /**
     * Gets all the Key-Value form of the text request parameter set:
     * <ul>
     * <li>Key: Request parameter name</li>
     * <li>Value: Request parameter value</li>
     * </ul>
     * 
     * @return Text request parameter set
     */
    protected Map<String, String> getPaginationParams()
    {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        if (pageSize > 0)
        {
            txtParams.put("page_size", String.valueOf(pageSize));
        }
        if (exclusiveFrom != null)
        {
            txtParams.put("exclusive_from", exclusiveFrom);
        }
        return txtParams;
    }

    @Override
    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkRange(pageSize, 0, 1000, "page_size");
    }
}
