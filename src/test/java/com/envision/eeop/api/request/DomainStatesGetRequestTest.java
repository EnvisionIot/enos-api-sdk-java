package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.domain.DomainState;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.DomainStatesGetResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by changyi.yuan on 2016/6/17.
 */
public class DomainStatesGetRequestTest {

//        private final static String GATEWAY = "http://localhost:8080";
    private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
//    private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

    @Test
    public void testDomainStates() throws EnvisionApiException {
        EnvisionClient client = new EnvisionDefaultClient(
                GATEWAY,
                "a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
                "0E133FBBFC57CA282FC2FC34C6651218");

        System.out.println("---------DomainStatesGetRequest--------------");
        List<String> mdmIds = new ArrayList<String>();
        mdmIds.add("b8d146ceb5064041ac17976257817a63");
        List<String> states = new ArrayList<String>();
        states.add("0");
        states.add("4");
        String beginTime = "2016-06-27 00:00:00";
        String endTime = "2016-06-29 00:00:00";
        DomainStatesGetRequest request = new DomainStatesGetRequest(
                mdmIds, states, beginTime, endTime);
        DomainStatesGetResponse response = client.execute(request);
        if (response == null) {
            System.out.println("Get Fail!");
        } else if (!response.isSuccess()) {
            System.out.println("status = " + response.getStatus() + ", msg = " + response.getMsg() + ", subMsg = " + response.getSubmsg());
        } else {
            for (DomainState ds : response.getDomainStateList()) {
                System.out.println(ds);
            }
        }
    }
}
