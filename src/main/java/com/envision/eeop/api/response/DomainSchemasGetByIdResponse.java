package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DomainInfo;

/**
 * Domain schemas
 * @author changhua.jiang
 */
public class DomainSchemasGetByIdResponse extends EnvisionResponse
{

    private DomainInfo domainInfo;

    public DomainInfo getDomainInfo()
    {
        return domainInfo;
    }

    public void setDomainInfo(DomainInfo domainInfo)
    {
        this.domainInfo = domainInfo;
    }
}
