package com.envision.eeop.api.request;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;
import com.envision.eeop.api.response.MdmObjectStructureGetResponse;
import com.envision.eeop.api.response.MdmObjectsGetResponse;
import com.envision.energy.login_server.share.ILoginService;
import com.envision.energy.login_server.share.constants.ResponseCode;
import com.envision.energy.login_server.share.data.Response;
import com.envision.energy.login_server.share.data.UserTokenInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class MdmFilteredObjectsGetRequestTest
{
    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";
//    private final static String GATEWAY = "http://localhost:8080/eeop";
    
    private final static String appKey = "9e7b9345-565d-400f-acc9-422bf13297b1";
    private final static String appSecret = "DEB7709FACCB019F373D36A2D563EAC1";

    private static ILoginService loginService;

    private static String configLocation = "consumer.xml";
    private static ApplicationContext context;
    
    static
    {
        context = new ClassPathXmlApplicationContext(configLocation);
        loginService = (ILoginService) context.getBean("LoginService");
    }

    @Test 
    public void testFilterByName() throws EnvisionApiException 
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, appKey, appSecret);
        
        Response<UserTokenInfo> tokenInfo =  loginService.login(
                appKey, appSecret, "cimsync_rcc", "test", "web");
        
        String token = null;
        if (tokenInfo.getCode() == ResponseCode.successful)
        {
            token = tokenInfo.getData().getAccessToken();
            System.out.println("token: " + token);
        }
        else
        {
            System.out.println("no token");
        }

//        MdmFilteredObjectsGetRequest request = new MdmFilteredObjectsGetRequest(
//                token, "56", 
//                ImmutableList.<Filter>of(),
//                Lists.<AppointedFilter>newArrayList(),
//                ImmutableList.of("name"));
        
//        MdmObjectStructureGetRequest request = new MdmObjectStructureGetRequest(
//                token, "56", ImmutableList.of("name"));
//        
//        MdmObjectAttributesGetRequest request = new MdmObjectAttributesGetRequest(
//                ImmutableList.of("119bb5f780dcabfbe05010acaf213d69"));
        
        MdmObjectsGetRequest request = new MdmObjectsGetRequest(
                ImmutableList.of("119bb5f780dcabfbe05010acaf213d69"), 
                ImmutableList.of("56"),
                ImmutableList.of("name"));

//        MdmObjectStructureGetResponse response = client.execute(request, token);
//        MdmObjectAttributesGetResponse response = client.execute(request, token);
        MdmObjectsGetResponse response = client.execute(request, token);
        
        System.out.println(response.getStatus());
        if (response.getStatus() == 0 && !response.getMdmChildObjects().isEmpty())
        {
            System.out.println(response.getMdmChildObjects().values().iterator().next());
        }
        else
        {
            System.out.println(response.getMsg());
        }
    }
    
    @Test
    public void testGetSystem() throws EnvisionApiException 
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, appKey, appSecret);
        
        Response<UserTokenInfo> tokenInfo =  loginService.login(
                appKey, appSecret, "test", "test", "web");
        
        String token = null;
        if (tokenInfo.getCode() == ResponseCode.successful)
        {
            token = tokenInfo.getData().getAccessToken();
            System.out.println("token: " + token);
        }
        else
        {
            System.out.println("no token");
        }
        
        MdmObjectStructureGetRequest request = new MdmObjectStructureGetRequest(
                token, "54", "name");
        
        MdmObjectStructureGetResponse response = client.execute(request, token);
        
        System.out.println(response.getStatus());
        if (response.getStatus() == 0)
        {
            if (!response.getMdmObjects().isEmpty())
            {
                System.out.println(response.getMdmObjects().iterator().next());
            }
        }
        else
        {
            System.out.println(response.getMsg());
        }
    }

}