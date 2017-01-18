package com.envision.eeop.api.request;

import org.junit.Test;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectInsertResponse;
import com.google.common.collect.ImmutableMap;

public class MdmObjectInsertRequestTest
{
    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";
    
    private final static String appKey = "9e7b9345-565d-400f-acc9-422bf13297b1";
    private final static String appSecret = "DEB7709FACCB019F373D36A2D563EAC1";

    @Test
    public void testInsertObject() throws EnvisionApiException
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, appKey, appSecret);
        String token = null;
        MdmObjectInsertRequest request = new MdmObjectInsertRequest(
                "WF0024", 21, 200, 
                ImmutableMap.of("name", "WTG1"), "WF0024WTG0001", "zh-CN");
        @SuppressWarnings("unused")
        MdmObjectInsertResponse response = client.execute(request, token);
    }
}
