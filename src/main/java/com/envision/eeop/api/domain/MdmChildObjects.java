/**
 * Project: eos-core
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

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
    
    public MdmChildObjects merge(MdmChildObjects another)
    {
        for (Entry<String,List<MdmObject>> anotherEntry: another.getMdmObjectList().entrySet())
        {
            String type = anotherEntry.getKey();
            List<MdmObject> mdmObjects = anotherEntry.getValue();
            if (mdmObjectList.containsKey(type))
            {
                TreeSet<MdmObject> mergeMdmObjects = new TreeSet<>(mdmObjectList.get(type));
                mergeMdmObjects.addAll(mdmObjects);
                mdmObjectList.put(type, new ArrayList<>(mergeMdmObjects));
            }
            else
            {
                mdmObjectList.put(type, mdmObjects);
            }
        }
        return this;
    }
    
    public String getLastElement()
    {
        List<String> maxMdmIDs = new ArrayList<>();
        for (List<MdmObject> mdmObjects: mdmObjectList.values())
        {
            if (!mdmObjects.isEmpty())
            {
                maxMdmIDs.add(mdmObjects.get(mdmObjects.size() - 1).getMdmID());
            }
        }
        if (!maxMdmIDs.isEmpty())
        {
            return Collections.max(maxMdmIDs);
        }
        else
        {
            return "";
        }
    }
}
