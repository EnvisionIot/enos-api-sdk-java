package com.envision.eeop.api.response;

import java.util.ArrayList;
import java.util.List;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmObjectConfigInfo;

public class MdmObjectsConfigResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 2002607309882321922L;
    
    private String siteId;
    private List<MdmObjectConfigInfo> objects = new ArrayList<>();

    public String getSiteId()
    {
        return siteId;
    }

    public void setSiteId(String siteId)
    {
        this.siteId = siteId;
    }

    public List<MdmObjectConfigInfo> getObjects()
    {
        return objects;
    }

    public void setObjects(List<MdmObjectConfigInfo> objects)
    {
        this.objects = objects;
    }
}
