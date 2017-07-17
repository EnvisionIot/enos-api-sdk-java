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
    
    public MdmObjectConfigInfo()
    {
    }
    
    public MdmObjectConfigInfo(String mdmID, int domainID)
    {
        this.mdmID = mdmID;
        this.domainID = domainID;
    }

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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + domainID;
        result = prime * result + ((mdmID == null) ? 0 : mdmID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        MdmObjectConfigInfo other = (MdmObjectConfigInfo) obj;
        if(domainID != other.domainID) return false;
        if(mdmID == null)
        {
            if(other.mdmID != null) return false;
        }
        else if(!mdmID.equals(other.mdmID)) return false;
        return true;
    }
}
