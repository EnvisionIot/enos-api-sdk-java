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
public class DomainDetailsGetRequestTest {

        private final static String GATEWAY = "http://10.21.8.124:8080/eeop";
//    private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
//    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testDomainDetails() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "CPGJM-HAHAHA",
                "0E133FBBFC57CA282FC2FC34C6651218");

        System.out.println("---------DomainDetailsGetRequest--------------");
        List<String> mdmIds = new ArrayList<String>();
//        mdmIds.add("90330ba3e21543cda4d0b8720a393fde");
        mdmIds.add("b8d146ceb5064041ac17976257817a63");
        List<String> metrics = new ArrayList<String>();
//        metrics.add("INV.InvtEffi");
//        metrics.add("INV.Freq");
//        metrics.add("WST.Radiation");
//        metrics.add("WST.Temperature");
//        metrics.add("WST.Humidity");

        metrics.add("CBX.Cur");

        String beginTime = "2016-12-08 00:00:00";
        String endTime = "2016-12-08 23:59:59";
        DomainDetailsGetRequest request = new DomainDetailsGetRequest(
                mdmIds, metrics, beginTime, endTime);
        DomainMetricsGetResponse response = client.execute(request, "CPGJM-HAHAHA");
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
