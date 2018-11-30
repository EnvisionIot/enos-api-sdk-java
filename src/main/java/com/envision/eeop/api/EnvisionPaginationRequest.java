package com.envision.eeop.api;

import java.util.Map;

import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

/**
 * Client Pagination Request
 *
 * @param <T>
 */
public abstract class EnvisionPaginationRequest<T extends EnvisionPaginationResponse>
implements EnvisionRequest<T>
{
    protected int pageNo = 0;         // optional

    protected int pageSize = 0;       // optional

    public int getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
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
            txtParams.put("page_no", String.valueOf(pageNo));
            txtParams.put("page_size", String.valueOf(pageSize));
        }
        return txtParams;
    }

    @Override
    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkRange(pageNo, 0, Integer.MAX_VALUE, "page_no");
        RuleCheckUtils.checkRange(pageSize, 0, 1000, "page_size");
    }
}
