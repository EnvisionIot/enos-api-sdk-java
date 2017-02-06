package com.envision.eeop.api.request;

import java.util.Map;

import org.junit.Test;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.domain.MdmObjectAttributes;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;
import com.envision.eeop.api.response.MdmObjectInsertResponse;
import com.google.common.collect.ImmutableList;

public class MdmObjectInsertRequestTest
{
    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";
    
    private final static String appKey = "9e7b9345-565d-400f-acc9-422bf13297b1";
    private final static String appSecret = "DEB7709FACCB019F373D36A2D563EAC1";

    @Test
    public void testInsertObject() throws EnvisionApiException
    {
        EnvisionClient client = new EnvisionDefaultClient(GATEWAY, appKey, appSecret);
        String token = "token-white-line";
        
        // get the attributes before update
        MdmObjectAttributesGetRequest attrRequest = new MdmObjectAttributesGetRequest(
                ImmutableList.of("3b2bd9e8b12a48dd96190f70ec8fd714"));
        
        MdmObjectAttributesGetResponse attrResponse = client.execute(attrRequest, token);
        MdmObjectAttributes object = attrResponse.getMdmObjects()
                .get("3b2bd9e8b12a48dd96190f70ec8fd714");
        
        System.out.println("============= Before update ================");
        System.out.println("equipmentAmount=" + object
                .getAttributes()
                .get("equipmentAmount"));

        Map<String,String> attributes = object.getAttributes();
        attributes.put("equipmentAmount", "82");
        attributes.put("longitude", "44.00");
        attributes.put("latitude", "");

        MdmObjectInsertRequest request = new MdmObjectInsertRequest(
                object.getAttributes().get("parentID"),
                21, 102, 
                attributes, "3b2bd9e8b12a48dd96190f70ec8fd714");
        MdmObjectInsertResponse response = client.execute(request, token);
        
        System.out.println("============= After update ================");
        System.out.println("equipmentAmount=" + response
                .getMdmObject()
                .getAttributes()
                .get("equipmentAmount"));
        
        attrResponse = client.execute(attrRequest, token);
        object = attrResponse.getMdmObjects()
                .get("3b2bd9e8b12a48dd96190f70ec8fd714");
        
        System.out.println("============= After update ================");
        System.out.println("equipmentAmount=" + object
                .getAttributes()
                .get("equipmentAmount"));
        
    }
}
