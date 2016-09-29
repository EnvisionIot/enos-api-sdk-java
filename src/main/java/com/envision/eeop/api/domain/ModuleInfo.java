package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ModuleInfo implements Serializable{
    private static final long serialVersionUID = 8152856670907570391L;
    
    public String id;
    public String name;
    public String icon;
    public String url;
    public int state;
    public int openMode;
    public int groupType;
    public List<String> specificSites = new ArrayList<>();
    public List<ModuleInfo> children = new ArrayList<>();
}
