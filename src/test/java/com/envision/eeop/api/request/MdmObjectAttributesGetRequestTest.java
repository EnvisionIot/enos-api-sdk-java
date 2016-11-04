package com.envision.eeop.api.request;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.domain.MdmObject;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;
import com.envision.eeop.api.response.MdmObjectStructureGetResponse;

/**
 * Test eeop/mdmService/getObjectAttributes
 * 
 * @author jieyuan.shen
 */
public class MdmObjectAttributesGetRequestTest
{

    Logger logger = LoggerFactory.getLogger(MdmObjectAttributesGetRequestTest.class);

    private static EnvisionClient client = 
            new EnvisionDefaultClient(
                    "http://10.21.8.124:8080/eeop", 
                    "07bbf978-f554-423e-b73f-aa941265d54a",
                    "78BF020CD5645E30469CD28EE44C9A6F");
    
    @Test
    public void testGetObjectStructure() throws EnvisionApiException
    {
        MdmObjectStructureGetRequest request = new MdmObjectStructureGetRequest(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0ODA4NDY3MTAsImNhdGVnb3J5X2xpc3QiOltdLCJ1c2VyX2lkIjoidGVzdCIsImNsaWVudF9pZCI6IjA3YmJmOTc4LWY1NTQtNDIzZS1iNzNmLWFhOTQxMjY1ZDU0YSJ9.t5_W6aL7LSjF5y2BQ9C5QCMxuY18EewIXds8DIwRhl8",
                "102");
        
        MdmObjectStructureGetResponse response = client.execute(request);

        for (MdmObject object: response.getMdmObjects())
        {
            System.out.println(String.format("%s, %s, %s", object.getMdmID(), object.getAttributes().get("objectTypeID"), 
                    object.getAttributes().get("name")));
        }
    }

    @Test
    public void testWithoutAttributes() throws EnvisionApiException
    {
        List<String> mdmIDList = Arrays.asList("a77502ba622942658ca116cef5b8cf6c", "a4755fbcbc4548ed82ffa33ce34c0539");

        MdmObjectAttributesGetRequest request = new MdmObjectAttributesGetRequest(mdmIDList);

        MdmObjectAttributesGetResponse response = client.execute(request);
        System.out.println(response.getBody());
        System.out.println(response.toString());
    }

    @Test
    public void testWithAttributes() throws EnvisionApiException
    {
        List<String> mdmIDList = Arrays.asList("a77502ba622942658ca116cef5b8cf6c", "a4755fbcbc4548ed82ffa33ce34c0539");
        List<String> attributeList = Arrays.asList("name", "branches");

        MdmObjectAttributesGetRequest request = new MdmObjectAttributesGetRequest(mdmIDList, attributeList);

        MdmObjectAttributesGetResponse response = client.execute(request);
        System.out.println(response.getBody());
        System.out.println(response.toString());
    }
}
