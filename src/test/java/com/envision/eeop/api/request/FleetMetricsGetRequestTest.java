package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/17.
 */
public class FleetMetricsGetRequestTest {

    //        private final static String GATEWAY = "http://localhost:8080";
//    private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testMultiMetrics() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "EEOP_TEST",
                "0E133FBBFC57CA282FC2FC34C6651218");

        System.out.println("---------FleetMetricsGetRequest--------------");
        List<String> mdmIds = new ArrayList<String>();
        mdmIds.add("1808127391874fa983800b2de517672a");
        mdmIds.add("9184ddb253464235948ac0c521e964a4");
        List<String> metrics = new ArrayList<String>();
        metrics.add("SITE.FullHour");
        String beginTime = "2016-08-03 00:00:00";
        String endTime = "2016-08-06 00:00:00";
        String timeGroup = "D";
        DomainMetricsGetRequest request = new DomainMetricsGetRequest(
                mdmIds, metrics, beginTime, endTime, timeGroup);
        DomainMetricsGetResponse response = client.execute(request, "token");
        if (response == null) {
            System.out.println("Get Fail!");
        } else if (!response.isSuccess()) {
            System.out.println("status = " + response.getStatus() + ", msg = " + response.getMsg() + ", subMsg = " + response.getSubmsg());
        } else {
            for (Map<String, String> m : response.getDomainMetricList()) {
                System.out.println(m);
            }
        }
    }
}
