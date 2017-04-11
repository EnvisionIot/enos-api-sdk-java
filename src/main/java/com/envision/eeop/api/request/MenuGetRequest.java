package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.MenuGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

public class MenuGetRequest implements EnvisionRequest<MenuGetResponse>{
    private static final String API_METHOD = "/appService/getAllMenus"; 
    
    private String siteId;           // mandatory
    private String token;            // mandatory
    private String spaceId;          // mandatory
    private String locale;           // optional
    private String userId;           // optional
    
    public MenuGetRequest(String siteId, String token, String spaceId){
        this.siteId = siteId;
        this.token = token;
        this.spaceId = spaceId;
        this.locale = "";
        this.userId = "";
    }
    
    public MenuGetRequest(String siteId, String token, String spaceId, String locale){
        this.siteId = siteId;
        this.token = token;
        this.spaceId = spaceId;
        this.locale = locale;
        this.userId = "";
    }
    
    public MenuGetRequest(String siteId, String token, String spaceId, String locale, String userId){
        this.siteId = siteId;
        this.token = token;
        this.spaceId = spaceId;
        this.locale = locale;
        this.userId = userId;
    }
    
    public String getApiMethodName(){
        return API_METHOD;
    }
    
    public Map<String, String> getTextParams(){
        EnvisionHashMap txtParams = new EnvisionHashMap();
        
        txtParams.put("siteId", siteId);
        txtParams.put("token", token);
        txtParams.put("spaceId", spaceId);
        txtParams.put("locale", locale);
        txtParams.put("userId", userId);
        
        return txtParams;
    }
    
    public Class<MenuGetResponse> getResponseClass(){
        return MenuGetResponse.class;
    }
    
    public void check() throws EnvisionRuleException{
        RuleCheckUtils.checkNotEmpty(siteId, "siteId");
        RuleCheckUtils.checkNotEmpty(token, "token");
        RuleCheckUtils.checkNotEmpty(spaceId, "spaceId");
    }
}
