package com.envision.eeop.api.request;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MenuGetResponse;

public class MenuGetRequestTest {
    Logger logger = LoggerFactory.getLogger(MenuGetRequestTest.class);
    
    private static EnvisionClient client = new EnvisionDefaultClient(
            "http://localhost:8080/eeop",
            "07bbf978-f554-423e-b73f-aa941265d54a",
            "78BF020CD5645E30469CD28EE44C9A6F");
    private String testToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjYXRlZ29yeV9saXN0IjpbXSwibm9kZV9saXN0Ijoie1wiNTdiZWQ0MWU2NGQ5ZWY2ZGE3MTcxZDZlXCI6W1wiQTAwMDFcIixcIkEwMDAyXCIsXCJBMDAwM1wiLFwiQjAwMDFcIixcIkEwMDA0XCIsXCJBMDAwNVwiLFwiQTAwMDZcIixcIlowMDA0XCJdfSIsImV4cCI6MTQ3NjMzOTI3OCwidXNlcl9pZCI6InRlc3QiLCJjbGllbnRfaWQiOiIwN2JiZjk3OC1mNTU0LTQyM2UtYjczZi1hYTk0MTI2NWQ1NGEifQ.JXBAb-UEfOk4vC7BCqNyyxJ7c0nCuAc7g5fMuNplX1A";
    @Test
    public void testgetAllMenus() throws EnvisionApiException {
        MenuGetRequest request = new MenuGetRequest("57babc57d3eb48287c47d4c8", testToken, "57bed41e64d9ef6da7171d6e", "zh");
        MenuGetResponse response = client.execute(request);
        
        System.out.println(response.isSuccess());
        System.out.println(response.getBody());
        System.out.println(response.getMenuInfos());
    }
}
