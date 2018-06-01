package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.EventContentGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

public class EventContentGetRequest implements EnvisionRequest<EventContentGetResponse>{
    private static final String API_METHOD = "/eventService/getEventContent";

    private String categoryId;
    private String locale;           // optional

    public EventContentGetRequest(String categoryId, String locale){
        this.categoryId = categoryId;
        this.locale = locale;
    }

    public EventContentGetRequest(String categoryId){
        this.categoryId = categoryId;
        this.locale = "";
    }
    
    public String getApiMethodName(){
        return API_METHOD;
    }
    
    public Map<String, String> getTextParams(){
        EnvisionHashMap txtParams = new EnvisionHashMap();
        
        txtParams.put("categoryid", categoryId);
        txtParams.put("locale", locale);
        
        return txtParams;
    }
    
    public Class<EventContentGetResponse> getResponseClass(){
        return EventContentGetResponse.class;
    }
    
    public void check() throws EnvisionRuleException{
        RuleCheckUtils.checkNotEmpty(categoryId, "categoryId");
        // RuleCheckUtils.checkNotEmpty(token, "token");
    }
}
