/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmPointMappingGetResponse;

/**
 * TODO Comment of MdmDomainPointMappingTest
 *
 */
public class MdmDomainPointMappingTest {

    private final static String GATEWAY = "http://localhost:8080/eeop";
//private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
//private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

@Test
public void testDomainDetails() throws EnvisionApiException {
    EnvisionClient client = new EnvisionDefaultClient(
            GATEWAY,
            "EEOP_TEST",
            "0E133FBBFC57CA282FC2FC34C6651218");

	List<String> mdmidList = Arrays.asList("02c182fbe5614b29923936e5cbad63ce", "08ad7923e1b241f491d27a321efc1e8a","ppp");
	List<String> pointList = Arrays.asList("CBX.STATUS002", "CBX.STATUS009", "CBX.STATUS008", "ggg");
    MdmPointMappingGetRequest request = new MdmPointMappingGetRequest(mdmidList, pointList);
    

    MdmPointMappingGetResponse response = client.execute(request);
    if (response == null) {
        System.out.println("Get Fail!");
    } else if (!response.isSuccess()) {
        System.out.println("status = " + response.getStatus() + ", msg = " + response.getMsg() + ", subMsg = " + response.getSubmsg());
    } else {
            System.out.println(response.getMdmMap());
        
    }
}
}
