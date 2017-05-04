package com.envision.eeop.api.request;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Test eeop/mdmService/setObjectAttributes
 * @author jieyuan.shen
 */
public class MdmObjectAttributesSetRequestTest
{

    Logger logger = LoggerFactory.getLogger(MdmObjectAttributesSetRequestTest.class);

    private static EnvisionClient client = 
            new EnvisionDefaultClient(
                    "http://172.16.33.223:8080/eeop", 
                    "07bbf978-f554-423e-b73f-aa941265d54a",
                    "78BF020CD5645E30469CD28EE44C9A6F");
    
    private String currValue;
    
    private static final String newValue = "6000";
    
    @Before
    public void setUp() throws EnvisionApiException
    {
        MdmObjectAttributesGetRequest request = new MdmObjectAttributesGetRequest(
                ImmutableList.of("fd9266f1-a425-42c6-a9aa-2ac04defc5ec"),
                ImmutableList.of("power"));
        MdmObjectAttributesGetResponse response = client.execute(request, "token-white-line");
        assertThat(response.getStatus(), equalTo(0));

        currValue = response.getMdmObjects().get("fd9266f1-a425-42c6-a9aa-2ac04defc5ec")
                .getAttributes().get("power");
        
        assertThat(currValue, not(equalTo(newValue)));
    }
    
    @After
    public void tearDown() throws EnvisionApiException
    {
        // restore it to current value
        MdmObjectAttributesSetRequest setRequest = new MdmObjectAttributesSetRequest(
                "fd9266f1-a425-42c6-a9aa-2ac04defc5ec",
                ImmutableMap.of("power", currValue));
        EnvisionResponse setResponse = client.execute(setRequest, "token-white-line");

        assertThat(setResponse.getStatus(), equalTo(0));

        MdmObjectAttributesGetRequest getRequest = new MdmObjectAttributesGetRequest(
                ImmutableList.of("fd9266f1-a425-42c6-a9aa-2ac04defc5ec"),
                ImmutableList.of("power"));
        MdmObjectAttributesGetResponse getResponse = client.execute(getRequest, "token-white-line");
        assertThat(getResponse.getStatus(), equalTo(0));

        assertThat(
                getResponse.getMdmObjects().get("fd9266f1-a425-42c6-a9aa-2ac04defc5ec")
                .getAttributes().get("power"),
                equalTo(currValue));
    }
    
    @Test
    public void testSetAttributes() throws EnvisionApiException
    {
        // set it to a new value
        MdmObjectAttributesSetRequest setRequest = new MdmObjectAttributesSetRequest(
                "fd9266f1-a425-42c6-a9aa-2ac04defc5ec",
                ImmutableMap.of("power", newValue));
        EnvisionResponse setResponse = client.execute(setRequest, "token-white-line");

        assertThat(setResponse.getStatus(), equalTo(0));

        MdmObjectAttributesGetRequest getRequest = new MdmObjectAttributesGetRequest(
                ImmutableList.of("fd9266f1-a425-42c6-a9aa-2ac04defc5ec"),
                ImmutableList.of("power"));
        MdmObjectAttributesGetResponse getResponse = client.execute(getRequest, "token-white-line");
        assertThat(getResponse.getStatus(), equalTo(0));

        assertThat(
                getResponse.getMdmObjects().get("fd9266f1-a425-42c6-a9aa-2ac04defc5ec")
                .getAttributes().get("power"),
                equalTo(newValue));
    }
}
