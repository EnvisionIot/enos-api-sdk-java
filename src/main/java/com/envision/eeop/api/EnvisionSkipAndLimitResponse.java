package com.envision.eeop.api;

/**
 * Client Limited Response
 */
public abstract class EnvisionSkipAndLimitResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 4860873621880776236L;

    protected long remaining;

    public EnvisionSkipAndLimitResponse()
    {

    }

    public long getRemaining()
    {
        return remaining;
    }

    public void setRemaining(long remaining)
    {
        this.remaining = remaining;
    }

    public boolean isLastPage()
    {
        return remaining == 0L;
    }
    
    /**
     * Merge another response
     * @param another
     */
    public abstract EnvisionSkipAndLimitResponse merge(EnvisionSkipAndLimitResponse another);
    
    /**
     * get last element of the response
     */
    public abstract String getLastElement();
}
