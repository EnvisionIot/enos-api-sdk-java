import com.envisioniot.enos.enosapi.api.request.connectservice.GetMeasurepointsDataByDeviceKeyRequest;
import com.envisioniot.enos.enosapi.api.resource.connectservice.MeasurepointStatus;
import com.envisioniot.enos.enosapi.common.exception.EnOSApiException;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.sdk.client.EnOSDefaultClient;

import java.util.List;

/**
 * Created by changyi.yuan on 2018/11/28.
 */
public class GetMeasurepointsDataByDeviceKeyRequestTest
{
    public static void main(String[] args) throws EnOSApiException
    {
        String enosApiUrl = "https://beta-portal-cn4.eniot.io:8081/enosapi";
        String accessKey = "EEOP_TEST";
        String secretKey = "xxx";
        EnOSDefaultClient myclient = new EnOSDefaultClient(enosApiUrl, accessKey, secretKey, 10000, 30000);

        String orgId = "1a6233d811000000";
        String productKey = "78FRQKph";
        String deviceKey = "yzDevice";
        GetMeasurepointsDataByDeviceKeyRequest request = new GetMeasurepointsDataByDeviceKeyRequest(orgId, productKey, deviceKey);

        EnOSResponse<List<MeasurepointStatus>> response = myclient.execute(request);
        if (response.getStatus() == 0)
        {
            List<MeasurepointStatus> measurepointStatusList = response.getData();
            for (MeasurepointStatus ms : measurepointStatusList)
            {
                System.out.println(ms.getPointId() + "," + ms.getPonitName() + "," + ms.getDataType() + "," + ms.getValue() + "," + ms.getTime());
            }
        } else {
            System.out.println(response.getMsg());
        }
    }
}
