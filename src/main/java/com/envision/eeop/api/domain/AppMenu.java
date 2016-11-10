package com.envision.eeop.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppMenu implements Serializable{
    private static final long serialVersionUID = -3356249611399229124L;
    
    public String appKey;
    public String appName;
    public String appNameEn;
    public String appNameZh;
    public boolean isMobile;
    public String appIcon;
    
    public List<Integer> appCatIndex = new ArrayList<>();
    public List<String> appCategory = new ArrayList<>();
    public List<ModuleInfo> modules = new ArrayList<>();
}
