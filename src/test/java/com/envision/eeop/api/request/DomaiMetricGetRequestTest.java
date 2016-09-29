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
public class DomaiMetricGetRequestTest {

        private final static String GATEWAY = "http://localhost:8080";
//    private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
//    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testSingleMetric() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
                "0E133FBBFC57CA282FC2FC34C6651218");

        System.out.println("---------DomainMetricGetRequest--------------");
        List<String> mdmIds = new ArrayList<String>();
        mdmIds.add("67c17f7cebd44323b764e853394af5e8");
        mdmIds.add("70106f0c458e4b3994e741670d6be659");
        String metric = "INV.GenActivePW";
        String beginTime = "2016-06-01 02:00:00";
        String endTime = "2016-06-06 00:00:00";
        String timeGroup = "D";
        String sortType = "ASC";
        DomainMetricGetRequest request = new DomainMetricGetRequest(
                mdmIds, metric, beginTime, endTime, timeGroup, sortType);
        DomainMetricsGetResponse response = client.execute(request);
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
