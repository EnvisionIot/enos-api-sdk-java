package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.ImportFinishGetResponse;
import com.envision.eeop.api.response.ImportRunGetResponse;
import com.envision.eeop.api.response.ImportStartGetResponse;
import org.junit.Test;

/**
 * Created by changyi.yuan on 2016/6/17.
 */
public class ImportServiceGetRequestTest {

    private final static String GATEWAY = "https://eos.envisioncn.com/eeop";

    @Test
    public void testImport() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "EEOP_TEST",
                "EEOP_TEST");
        String token = "TEST_TOKEN";

        System.out.println("---------ImportStartGetRequest--------------");
        ImportStartGetRequest importStartGetRequest = new ImportStartGetRequest();
        ImportStartGetResponse importStartGetResponse = client.execute(importStartGetRequest, token);
        if (importStartGetResponse == null || !importStartGetResponse.isSuccess()) {
            return;
        }
        System.out.println("ImportStartGetRequest===> taskid: " + importStartGetResponse.getTaskId());

        System.out.println("---------ImportRunGetRequest--------------");
        String taskId = importStartGetResponse.getTaskId();
        String data = "test";
        ImportRunGetRequest importRunGetRequest = new ImportRunGetRequest(taskId, data);
        ImportRunGetResponse importRunGetResponse = client.execute(importRunGetRequest, token);
        if (importRunGetResponse == null || !importRunGetResponse.isSuccess()) {
            return;
        }
        System.out.println("ImportStartGetRequest===> result: " + importRunGetResponse.getMsg());

        System.out.println("---------ImportFinishGetRequest--------------");
        String attr = "some attribution about the task...";
        ImportFinishGetRequest importFinishGetRequest = new ImportFinishGetRequest(taskId, attr);
        ImportFinishGetResponse importFinishGetResponse = client.execute(importFinishGetRequest, token);
        if (importFinishGetResponse == null || !importFinishGetResponse.isSuccess()) {
            return;
        }
        System.out.println("ImportFinishGetRequest===> result: " + importFinishGetResponse.getMsg());

    }
}
