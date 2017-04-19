/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.io.Serializable;

/**
 * This class defines the result information of a configured object
 * @author jieyuan.shen
 */
public class MdmObjectConfigInfo implements Serializable
{
    private static final long serialVersionUID = 352695678286622448L;
    
    private String mdmID;
    private int domainID;

    public String getMdmID()
    {
        return mdmID;
    }

    public void setMdmID(String mdmID)
    {
        this.mdmID = mdmID;
    }

    public int getDomainID()
    {
        return domainID;
    }

    public void setDomainID(int domainID)
    {
        this.domainID = domainID;
    }

    @Override
    public String toString()
    {
        return "MdmObjectConfigInfo [mdmID=" + mdmID + ", domainID=" + domainID + "]";
    }
}
