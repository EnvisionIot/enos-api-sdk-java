package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AppResourceGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;

import java.util.Map;

public class AppResourceGetRequest implements EnvisionRequest<AppResourceGetResponse>{
    private static final String API_METHOD = "/appService/getAppResource";
    
    public String getApiMethodName(){
        return API_METHOD;
    }
    
    public Map<String, String> getTextParams(){
        EnvisionHashMap txtParams = new EnvisionHashMap();
        
        return txtParams;
    }
    
    public Class<AppResourceGetResponse> getResponseClass(){
        return AppResourceGetResponse.class;
    }
    
    public void check() throws EnvisionRuleException{
    }
}
