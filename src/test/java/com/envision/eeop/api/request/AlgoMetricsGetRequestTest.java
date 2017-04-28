package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.AlgoMetricsGetResponse;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/17.
 */
public class AlgoMetricsGetRequestTest {

//        private final static String GATEWAY = "http://localhost:8080";
    private final static String GATEWAY = "http://10.21.10.13:8080/eeop";
//    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testDomainPoints() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "EEOP_TEST",
                "TEST");

        System.out.println("---------DomainMetricsGetRequest--------------");
        List<String> mdmIds = new ArrayList<String>();
        mdmIds.add("16ac44dedf19e000");
        List<String> domainPoints = new ArrayList<String>();
        domainPoints.add("DRMS.LoadForecast.Daily");
        String beginTime = "2017-01-01 00:00:00";
        String endTime = "2017-01-02 00:00:00";
        String timeGroup = "D";
        AlgoMetricsGetRequest request = new AlgoMetricsGetRequest(
                mdmIds, domainPoints, beginTime, endTime, timeGroup);
        AlgoMetricsGetResponse response = client.execute(request);
        if (response == null) {
            System.out.println("Get Fail!");
        } else if (!response.isSuccess()) {
            System.out.println("status = " + response.getStatus() + ", msg = " + response.getMsg() + ", subMsg = " + response.getSubmsg());
        } else {
            for (Map<String, String> m : response.getMetricList()) {
                System.out.println(m);
            }
        }
    }
}
