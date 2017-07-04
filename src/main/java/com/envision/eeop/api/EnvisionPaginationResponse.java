package com.envision.eeop.api;

/**
 * Client Pagination Response
 */
public class EnvisionPaginationResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -2395824269031360535L;

    protected int remainingPages;

    public EnvisionPaginationResponse()
    {

    }

    public int getRemainingPages()
    {
        return remainingPages;
    }

    public void setRemainingPages(int remainingPages)
    {
        this.remainingPages = remainingPages;
    }

    public boolean isLastPage()
    {
        return remainingPages == 0;
    }
}
