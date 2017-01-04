/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class MdmChildObjects extends MdmObjectAttributes
{
    private static final long serialVersionUID = -905511497091094031L;

    @SerializedName("mdmobjects")
    private Map<String/* type */, List<MdmObject>> mdmObjectList;

    public MdmChildObjects()
    {
        super();
    }

    /**
     * @deprecated use {@link #MdmChildObjects(Map, Map)} instead
     */
    public MdmChildObjects(Map<String, List<MdmObject>> mdmObjectList)
    {
        super();
        this.mdmObjectList = mdmObjectList;
    }
    
    public MdmChildObjects(Map<String, String> attributes, Map<String, List<MdmObject>> mdmObjectList)
    {
        super(attributes);
        this.mdmObjectList = mdmObjectList;
    }

    public Map<String, List<MdmObject>> getMdmObjectList()
    {
        return mdmObjectList;
    }

    public void setMdmObjectList(Map<String, List<MdmObject>> mdmObjectList)
    {
        this.mdmObjectList = mdmObjectList;
    }

    @Override
    public String toString()
    {
        return "MdmChildObjects [mdmObjects=" + mdmObjectList + ", attributes=" + attributes + "]";
    }
}
