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
public class DomaiDetailsGetRequestTest {

        private final static String GATEWAY = "http://localhost:8080";
//    private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
//    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testDomainDetails() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
                "0E133FBBFC57CA282FC2FC34C6651218");

        System.out.println("---------DomainDetailsGetRequest--------------");
        List<String> mdmIds = new ArrayList<String>();
//        mdmIds.add("90330ba3e21543cda4d0b8720a393fde");
        mdmIds.add("0cf22ff7cb854ba5b7786f2196466821");
        List<String> metrics = new ArrayList<String>();
//        metrics.add("INV.InvtEffi");
//        metrics.add("INV.Freq");
        metrics.add("WST.Radiation");
        metrics.add("WST.Temperature");
        metrics.add("WST.Humidity");
        String beginTime = "2016-06-19 13:00:00";
        String endTime = "2016-06-19 15:00:00";
        DomainDetailsGetRequest request = new DomainDetailsGetRequest(
                mdmIds, metrics, beginTime, endTime);
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
