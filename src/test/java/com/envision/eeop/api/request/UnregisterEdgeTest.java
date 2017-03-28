package com.envision.eeop.api.request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
import com.google.common.collect.Queues;

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
    
    private static ExecutorService executor = new ThreadPoolExecutor(
            2, 4, 20L, TimeUnit.SECONDS,
            Queues.<Runnable>newArrayBlockingQueue(16));

    @Test
    public void unregisterInvalidBox() throws EnvisionApiException, IOException, InterruptedException
    {
        // load box ids
        List<String> boxIDList = Files.readAllLines(Paths.get("sites.csv"), Charsets.UTF_8);

        Queue<String> boxIDs = Queues.newLinkedBlockingDeque();
        
        for (String boxID: boxIDList)
        {
            boxIDs.offer(boxID);
        }

        int totalSize = boxIDs.size();
        
        String boxID = boxIDs.peek();
        while (boxID != null)
        {
            try
            {
                executor.submit(new UnregisterTask(boxID));
                boxIDs.remove();
                System.out.println(String.format("%d/%d left", boxIDs.size(), totalSize));
            }
            catch (RejectedExecutionException e)
            {
                // sleep 200 ms
                System.out.println("sleep 500 ms");
                TimeUnit.MILLISECONDS.sleep(500);
            }
            
            boxID = boxIDs.peek();
        } 
    }

    @Test
    public void unregisterAll() throws EnvisionApiException, InterruptedException 
    {
        // get all sites under test area
        MdmObjectsGetRequest mdmObjectsGetRequest = new MdmObjectsGetRequest(
                ImmutableList.of("16ae915d9a036000"),
                ImmutableList.of("58"),
                ImmutableList.of("name"));
        
        MdmObjectsGetResponse mdmObjectsGetResponse = 
                client.execute(mdmObjectsGetRequest, "token-white-line");
        
        Queue<String> boxIDs = Queues.newLinkedBlockingDeque();
        
        for (MdmObject site: 
                mdmObjectsGetResponse.getMdmChildObjects().get("16ae915d9a036000")
                .getMdmObjectList().get("58"))
        {
            List<String> items = Splitter.on('_').splitToList(site.getAttributes().get("name"));
            String boxID = items.get(1);
            boxIDs.offer(boxID);
        }
        
        int totalSize = boxIDs.size();
        
        String boxID = boxIDs.peek();
        while (boxID != null)
        {
            try
            {
                executor.submit(new UnregisterTask(boxID));
                boxIDs.remove();
                System.out.println(String.format("%d/%d left", boxIDs.size(), totalSize));
            }
            catch (RejectedExecutionException e)
            {
                // sleep 200 ms
                System.out.println("sleep 500 ms");
                TimeUnit.MILLISECONDS.sleep(500);
            }
            
            boxID = boxIDs.peek();
        } 
    }
    
    
    private static class UnregisterTask implements Runnable
    {
        String boxID;

        UnregisterTask(String boxID)
        {
            this.boxID = boxID;
        }

        @Override
        public void run()
        {
            try
            {
                EdgeUnregisterRequest edgeUnregisterRequest = new EdgeUnregisterRequest(boxID);
                EnvisionResponse response = registerClient.execute(edgeUnregisterRequest, "token-white-line");
                System.out.println("unregister " + boxID + ", result: " + response.getStatus());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
