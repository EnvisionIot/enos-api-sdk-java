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
public class FileDownloadRequestTest {
   /* private final static String GATEWAY = "http://localhost:8080/eeop";

    @Test
    public void testDownload() throws EnvisionApiException, IOException {
        EnvisionStreamClient client = new EnvisionDefaultStreamClient(GATEWAY,
                "EEOP_TEST",
                "0E133FBBFC57CA282FC2FC34C6651218");

        String mdmId = "b8d146ceb5064041ac17976257817a63";
        String timestamp = "20161018";
        File file = new File("D:\\changyi.yuan\\Desktop\\tmp\\CBX-download.sql");
        FileDownloadRequest request = new FileDownloadRequest(mdmId, timestamp, file);

        String token = "";

        client.download(request, token);

        File rawFile = new File("D:\\changyi.yuan\\Desktop\\tmp\\CBX.sql");
        if (file.length() != rawFile.length()) {
            System.out.println("downloaded file length : " + file.length());
            System.out.println("raw file length : " + rawFile.length());
            System.out.println("content wrong!");
        }
    }*/
}
