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
    private int pageNo = 0;         // optional

    private int pageSize = 0;       // optional

    protected int getPageNo()
    {
        return pageNo;
    }

    protected void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }

    protected int getPageSize()
    {
        return pageSize;
    }

    protected void setPageSize(int pageSize)
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
            txtParams.put("page_no", pageNo);
            txtParams.put("page_size", pageSize);
        }
        return txtParams;
    }

    /*
     * check request
     */
    public void check() throws EnvisionRuleException
    {
        RuleCheckUtils.checkRange(pageNo, 0, Integer.MAX_VALUE, "page_no");
        RuleCheckUtils.checkRange(pageSize, 0, 200, "page_size");
    }
}
