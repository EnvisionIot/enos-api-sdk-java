package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.PushSingleResponse;
import com.envision.eeop.api.util.JsonParser;
import org.junit.Test;

/**
 * Created by zhiqi.yang on 2017/1/4.
 */
public class PushSingleRequestTest {
    private final static String GATEWAY = "http://172.16.33.223:8080/eeop/";
//    private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
//    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testPush(){
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "7ee38d4e-4b1d-4f4d-ad04-ba892df0a7ef",
                "5B34CB700F5A328B71C4BDCC0CE59D49");
        PushSingleRequest request = new PushSingleRequest("tagTest","contentTest");
        try {
            PushSingleResponse response = client.execute(request);
            System.out.println(JsonParser.toJson(response));
        } catch (EnvisionApiException e) {
            e.printStackTrace();
        }
    }
}
