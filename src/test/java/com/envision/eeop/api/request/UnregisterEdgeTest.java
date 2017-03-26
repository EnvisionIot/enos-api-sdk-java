package com.envision.eeop.api.request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.MdmObject;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectsGetResponse;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;

/**
 * Test eeop/registerService/unregisterEdge
 * 
 * @author jieyuan.shen
 */
public class UnregisterEdgeTest
{

    Logger logger = LoggerFactory.getLogger(UnregisterEdgeTest.class);

    private static EnvisionClient client = new EnvisionDefaultClient(
            "http://10.21.10.13:8080/eeop", "EEOP_TEST", "dummy");

    private static EnvisionClient registerClient = new EnvisionDefaultClient(
            "http://10.21.10.13:8080/eeop", "HEMS_REGISTER_TEST", "dummy");

    @Test
    public void unregisterInvalidBox() throws EnvisionApiException, IOException
    {
        // load box ids
        List<String> boxIDs = Files.readAllLines(Paths.get("sites.csv"), Charsets.UTF_8);

        for (String boxID: boxIDs)
        {
            EdgeUnregisterRequest edgeUnregisterRequest = new EdgeUnregisterRequest(boxID);
            EnvisionResponse response = registerClient.execute(edgeUnregisterRequest, "token-white-line");
            System.out.println("unregister " + boxID + ", result: " + response.getStatus());
        }
    }

    @Test
    public void unregisterAll() throws EnvisionApiException
    {
        // get all sites under test area
        MdmObjectsGetRequest mdmObjectsGetRequest = new MdmObjectsGetRequest(
                ImmutableList.of("16ae915d9a036000"),
                ImmutableList.of("58"),
                ImmutableList.of("name"));
        
        MdmObjectsGetResponse mdmObjectsGetResponse = 
                client.execute(mdmObjectsGetRequest, "token-white-line");
        
        for (MdmObject site: 
                mdmObjectsGetResponse.getMdmChildObjects().get("16ae915d9a036000")
                .getMdmObjectList().get("58"))
        {
            List<String> items = Splitter.on('_').splitToList(site.getAttributes().get("name"));
            String boxID = items.get(1);
           
            // dry run
            EdgeUnregisterRequest edgeUnregisterRequest = new EdgeUnregisterRequest(boxID);
            EnvisionResponse response = registerClient.execute(edgeUnregisterRequest, "token-white-line");
            System.out.println("unregister " + boxID + ", result: " + response.getStatus());
        }
    }
}
