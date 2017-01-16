/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.CountGetResponse;
import com.envision.eeop.api.response.DimensionGetResponse;
import com.envision.eeop.api.response.DimensionsGetResponse;
import com.envision.energy.login_server.share.ILoginService;
import com.envision.energy.login_server.share.constants.ResponseCode;
import com.envision.energy.login_server.share.data.Response;
import com.envision.energy.login_server.share.data.UserTokenInfo;

/**
 * TODO Comment of DoaminControlTest
 *
 */
public class DimensionTest
{
    //private final static String GATEWAY = "http://localhost:8080/eeop";

    // private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";
    
    private final static String appKey = "9e7b9345-565d-400f-acc9-422bf13297b1";
    private final static String appSecret = "DEB7709FACCB019F373D36A2D563EAC1";

    private static ILoginService loginService;

    private static String configLocation = "consumer.xml";
    private static ApplicationContext context;
    
//    private static class AppStartup extends MavenStandardProject
//    {
//
//        @Override
//        protected List<String> _getSpringXML()
//        {
//            return Lists.newArrayList("consumer.xml");
//            //return super._getSpringXML();
//        }
//    }
//    
//    private static final AppStartup app = new AppStartup();

    static
    {
        context = new ClassPathXmlApplicationContext(configLocation);
        loginService = (ILoginService) context.getBean("LoginService");
    }

    @Test public void testFindByColumns() throws EnvisionApiException
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, "a0720bb5-916c-43e2-b8e4-b129cfaf8bb6", "0E133FBBFC57CA282FC2FC34C6651218");

        Map<String, Object> map = new HashMap<String, Object>();
        // map.put("a", 1);
        map.put("description", "维护停机");

        DimensionFindByColumnsRequest request = new DimensionFindByColumnsRequest("57baab592b0f1cfd669469d2", "standardstate", map);
        DimensionsGetResponse response = client.execute(request);
        if(response.isSuccess())
        {
            System.out.println(response.getDimensions());
        }
    }

    @Test
    public void testInsert() throws EnvisionApiException
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, "a0720bb5-916c-43e2-b8e4-b129cfaf8bb6", "0E133FBBFC57CA282FC2FC34C6651218");

        Map<String, Object> map = new HashMap<String, Object>();
        // map.put("a", 1);
        map.put("description", "维护停机");

        DimensionInsertRequest request = new DimensionInsertRequest("111111", "57baab592b0f1cfd669469d2", "standardstate", map);
        EnvisionResponse response = client.execute(request);
        System.out.println(response.getBody());

    }

    @Test
    public void testFindByKey() throws EnvisionApiException
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
        
        if (token != null)
        {
//            DimensionFindByKeyRequest request = new DimensionFindByKeyRequest(
//                    "119bb5f780dcabfbe05010acaf213d69", "test_component", "4");
//
            DimensionFindByKeyRequest request = new DimensionFindByKeyRequest(
                    "57baab592b0f1cfd669469d2", "province", "110000");
            
            DimensionGetResponse response = client.execute(request, token);
            String soundNum = (String) response.getDimensionMap().get("description");
            System.out.println(response.getBody());
            System.out.println(soundNum);
        }
    }

    @Test
    public void testFindByKeys() throws EnvisionApiException
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, "EEOP_TEST", "0E133FBBFC57CA282FC2FC34C6651218");

        List<String> keys = new ArrayList<>();
        keys.add("id5");
        keys.add("id6");
        DimensionFindByKeysRequest request = new DimensionFindByKeysRequest("111111", "test1", keys);
        DimensionsGetResponse response = client.execute(request, "zzz");
        System.out.println(response.getBody() + ":" + response.toString());
    }

    @Test
    public void testDeleteByKey() throws EnvisionApiException
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, "EEOP_TEST", "0E133FBBFC57CA282FC2FC34C6651218");

        DimensionDeleteByKeyRequest request = new DimensionDeleteByKeyRequest("111111", "test1", "id5");
        CountGetResponse response = client.execute(request, "zzz");
        System.out.println(response.getBody() + ":" + response.toString());
    }
}
