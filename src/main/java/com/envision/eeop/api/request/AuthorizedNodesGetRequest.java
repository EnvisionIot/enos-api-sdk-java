package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AuthorizedNodeGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;

public class AuthorizedNodesGetRequest implements EnvisionRequest<AuthorizedNodeGetResponse>
{
   private static final String API_METHOD = "/debugService/getAuthorizedNodes";
   
   private boolean checkAppCategory = false;    // optional

public AuthorizedNodesGetRequest(boolean checkAppCategory)
   {
       this.checkAppCategory = checkAppCategory;
   }
   
   public boolean isCheckAppCategory()
{
    return checkAppCategory;
}

public void setCheckAppCategory(boolean checkAppCategory)
{
    this.checkAppCategory = checkAppCategory;
}

   @Override
   public String getApiMethodName()
   {
       return API_METHOD;
   }

   @Override
   public Map<String, String> getTextParams()
   {
       EnvisionHashMap txtParams = new EnvisionHashMap();
       if (checkAppCategory)
       {
           txtParams.put("checkAppCategory", String.valueOf(true));
       }
       return txtParams;
   }

   @Override
   public Class<AuthorizedNodeGetResponse> getResponseClass()
   {
       return AuthorizedNodeGetResponse.class;
   }

   @Override
   public void check() throws EnvisionRuleException
   {
       // do nothing
   }
}
