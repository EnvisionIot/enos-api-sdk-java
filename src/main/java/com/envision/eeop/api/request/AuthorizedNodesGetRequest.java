package com.envision.eeop.api.request;

import java.util.Map;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.AuthorizedNodesGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;

public class AuthorizedNodesGetRequest implements EnvisionRequest<AuthorizedNodesGetResponse>
{
   private static final String API_METHOD = "/debugService/getAuthorizedNodes";
   
   private String operationCode;                // optional
   private boolean checkAppCategory = false;    // optional

   public AuthorizedNodesGetRequest(boolean checkAppCategory)
   {
       this.checkAppCategory = checkAppCategory;
   }

   public AuthorizedNodesGetRequest(String operationCode, boolean checkAppCategory)
   {
       this.operationCode = operationCode;
       this.checkAppCategory = checkAppCategory;
   }

   public String getOperationCode()
   {
       return operationCode;
   }

   public void setOperationCode(String operationCode)
   {
       this.operationCode = operationCode;
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
       if (operationCode != null)
       {
           txtParams.put("operation", operationCode);
       }
       if (checkAppCategory)
       {
           txtParams.put("checkAppCategory", String.valueOf(true));
       }
       return txtParams;
   }

   @Override
   public Class<AuthorizedNodesGetResponse> getResponseClass()
   {
       return AuthorizedNodesGetResponse.class;
   }

   @Override
   public void check() throws EnvisionRuleException
   {
       // do nothing
   }
}
