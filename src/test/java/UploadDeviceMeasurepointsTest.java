import com.envisioniot.enos.enosapi.api.request.connectservice.UploadDeviceMeasurepointsRequest;
import com.envisioniot.enos.enosapi.common.exception.EnOSApiException;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.sdk.client.EnOSDefaultClient;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by changyi.yuan on 2018/11/21.
 */
public class UploadDeviceMeasurepointsTest
{
    public static void main(String[] args) throws EnOSApiException
    {
/*        String enosApiUrl = "https://beta-portal-cn4.eniot.io:8081/enosapi";
//        String enosApiUrl = "http://localhost:8080";
        String accessKey = "EEOP_TEST";
        String secretKey = "xxx";
        EnOSDefaultClient client = new EnOSDefaultClient(enosApiUrl, accessKey, secretKey, 10000, 30000);

        String orgId = "1a6233d811000000";
        String productKey = "78FRQKph";

        String data = "[{\"measurepoints\":{\"myPhoto\":\"s3://aFile\",\"normal\": 2.33},\"time\":1542699685903,\"assetId\":\"51Dilemr\"}]";
        Map<String, File> files = new HashMap<>();
//        files.put("aFile", new File("D:\\changyi.yuan\\Desktop\\root.crt"));

        UploadDeviceMeasurepointsRequest request = new UploadDeviceMeasurepointsRequest(orgId, productKey, data, files);

        EnOSResponse response = client.execute(request);
        System.out.println(response.getStatus());
        System.out.println(response.getMsg());
        System.out.println(response.getSubmsg());*/


//        String enosApiUrl = "http://localhost:8080";
//        String enosApiUrl = "http://10.27.20.148:8080/enosapi";
        String enosApiUrl = "https://beta-portal-cn4.eniot.io:8081/enosapi";
        String accessKey = "EEOP_TEST";
        String secretKey = "xxx";
        EnOSDefaultClient myclient = new EnOSDefaultClient(enosApiUrl, accessKey, secretKey, 10000, 30000);
        String orgId = "1a6233d811000000";
        String productKey = "78FRQKph";

//        String data = "[{\"measurepoints\":{\"myPhoto\":\"hdfs://aFile\",\"normal\": 2.33},\"time\":1542699685903,\"assetId\":\"51Dilemr\"}]";
        String data = "[{\"measurepoints\":{\"myPhoto\":\"local://image1\",\"normal\": 2.33},\"time\":1542699685903,\"assetId\":\"tMZSVxS0\"}]";

        Map<String, File> files = new HashMap<>();
        files.put("image1", new File("C:\\Users\\changyi.yuan\\Documents\\beta.host"));

        UploadDeviceMeasurepointsRequest request = new UploadDeviceMeasurepointsRequest(orgId, productKey, data, files);
        EnOSResponse response = myclient.execute(request);
        System.out.println(response.getStatus() == 0 ? "success: " + response.getData() : "error: " + response.getMsg());
    }
}
