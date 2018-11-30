package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppMenu implements Serializable{
    private static final long serialVersionUID = -3356249611399229124L;
    
    public String appKey;
    public String appName;
    public String appNameEn;
    public String appNameZh;
    public boolean isMobile;
    public String appIcon;
    public String appLink;
    
    public List<Integer> appCatIndex = new ArrayList<>();
    public List<String> appCategory = new ArrayList<>();
    public List<ModuleInfo> modules = new ArrayList<>();
    public Map<String, Set<String>> permissionMap = new HashMap<>();
}
