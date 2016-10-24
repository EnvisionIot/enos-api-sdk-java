package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionDefaultStreamClient;
import com.envision.eeop.api.EnvisionStreamClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by changyi.yuan on 2016/10/18.
 */
public class FileUploadRequestTest {
    /*private final static String GATEWAY = "http://localhost:8080/eeop";

    @Test
    public void testUpload() throws EnvisionApiException, IOException {
        EnvisionStreamClient client = new EnvisionDefaultStreamClient(GATEWAY,
                "EEOP_TEST",
                "0E133FBBFC57CA282FC2FC34C6651218");

        String mdmId = "b8d146ceb5064041ac17976257817a63";
        String timestamp = "20161019";
        File file = new File("D:\\changyi.yuan\\Desktop\\tmp\\CBX.sql");
        FileUploadRequest request = new FileUploadRequest(mdmId, timestamp, file);

        String token = "";

        client.upload(request, token);
    }*/
}
