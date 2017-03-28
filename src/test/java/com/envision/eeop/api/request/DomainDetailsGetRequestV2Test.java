package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.DomainDetailsGetResponseV2;
import com.envision.eeop.api.response.DomainMetricsGetResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/17.
 */
public class DomainDetailsGetRequestV2Test {

//        private final static String GATEWAY = "http://10.21.8.124:8080/eeop";
//    private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testDomainDetails() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "EEOP_TEST",
                "0E133FBBFC57CA282FC2FC34C6651218");

        System.out.println("---------DomainDetailsGetRequestV2--------------");

        String mdmId = "WF0024WTG0001";
        String metric = "WNAC.NacellePosition";
        String beginTime = "2017-03-20 00:00:00";
        String endTime = "2017-03-27 00:00:00";
        String interval = "1s";
        Integer limit = 1000;

        DomainDetailsGetRequestV2 request = new DomainDetailsGetRequestV2(
                mdmId, metric, beginTime, endTime, interval, limit);
        DomainDetailsGetResponseV2 response = client.execute(request, "CPGJM-HAHAHA");
        if (response == null) {
            System.out.println("Get Fail!");
        } else if (!response.isSuccess()) {
            System.out.println("status = " + response.getStatus() + ", msg = " + response.getMsg() + ", subMsg = " + response.getSubmsg());
        } else {
            for (Map<String, String> m : response.getDetails()) {
                System.out.println(m);
            }
        }
    }
}
