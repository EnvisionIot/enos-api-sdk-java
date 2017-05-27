package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.EnvisionDefaultStreamClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.AysnFileDownloadResponse;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by changyi.yuan on 2016/10/18.
 */
@SuppressWarnings("unused")
public class FileDownloadRequestTest {
//    private final static String EEOP_GATEWAY = "http://172.16.33.223:8080/eeop";
//    private final static String EEOP_GATEWAY = "http://10.21.10.13:8080/eeop";
    private final static String EEOP_GATEWAY = "http://10.21.8.124:8080/eeop";

    //just for test
    private final static String APP_KEY = "CPGJM-HAHAHA";
    private final static String APP_SECRET = "TEST";
    private final static String TOKEN = "TEST";

    private final static int DOWNLOAD_SUCCESS_CODE = 0;

    private final static String STATUS_WAITING_CODE = "0";
    private final static String STATUS_RUNNING_CODE = "1";
    private final static String STATUS_FAIL_CODE = "2";
    private final static String STATUS_SUCCESS_CODE = "3";

    @Test
    public void testAsyncDownload() throws EnvisionApiException, IOException, InterruptedException {
        EnvisionDefaultClient client = new EnvisionDefaultClient(EEOP_GATEWAY, APP_KEY, APP_SECRET);
        EnvisionDefaultStreamClient streamClient = new EnvisionDefaultStreamClient(EEOP_GATEWAY, APP_KEY, APP_SECRET);

        //1. send file download request
        String mdmId = "c1489f0e-602d-4162-89f4-b835a54fc73c";
        String tableName = "WIND_10_MIN_DATA";
        String beginTime = "20170402";
        String endTime = "20170405";

        //retrieve token from tokenService in the real world
        String token = "TEST_TOKEN";

        AsynFileDownloadRequest downloadRequest = new AsynFileDownloadRequest();
        downloadRequest.setMdmId(mdmId);
        downloadRequest.setTableName(tableName);
        downloadRequest.setBeginTime(beginTime);
        downloadRequest.setEndTime(endTime);

        AysnFileDownloadResponse response = client.execute(downloadRequest, TOKEN);

        //2. check download status every 10s
        AysnFileDownloadResponse statusResponse = null;
        String id = response == null ? null : response.getId();
        if (id != null && DOWNLOAD_SUCCESS_CODE == response.getStatus()) {
            AsynFileGenerateQueryRequest queryRequest = new AsynFileGenerateQueryRequest(mdmId, id);
            statusResponse = client.execute(queryRequest, token);
            while (statusResponse != null && (STATUS_WAITING_CODE.equals(statusResponse.getCode()) || STATUS_RUNNING_CODE.equals(statusResponse.getCode()))) {
                statusResponse = client.execute(queryRequest, token);
                Thread.sleep(10000);
            }
        }
        if (id == null || statusResponse == null || !STATUS_SUCCESS_CODE.equals(statusResponse.getCode())) {
            System.out.println("Failed! Try again!");
            System.exit(0);
        }

        //3. download file if it is finished status
        File file = new File("D:\\changyi.yuan\\Desktop\\tmp\\test.txt");
        AsyncFileDownloadExecuteRequest downloadExecuteRequest = new AsyncFileDownloadExecuteRequest(mdmId, id, file);
        boolean result = streamClient.download(downloadExecuteRequest, token);
        if (result) {
            System.out.println(" Congratulation! Data download successfully!");
        } else {
            System.out.println("Sorry! Failed to download!");
        }
    }

    /*@Test
    public void testDownload() throws EnvisionApiException, IOException {
        EnvisionStreamClient client = new EnvisionDefaultStreamClient(EEOP_GATEWAY,
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
