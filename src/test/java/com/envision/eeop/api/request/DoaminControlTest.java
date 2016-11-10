/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import org.junit.Test;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionApiException;

/**
 * TODO Comment of DoaminControlTest
 *
 */
public class DoaminControlTest {
//    private final static String GATEWAY = "http://localhost:8080/eeop/";
//  private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
  private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

  @Test
  public void testDomainDetails() throws EnvisionApiException {
      EnvisionClient client = new EnvisionDefaultClient(
              GATEWAY,
              "EEOP_TEST",
              "0E133FBBFC57CA282FC2FC34C6651218");
      
      DomainControlRequest request = new DomainControlRequest("931b03e4-6c52-4c7a-af14-9f9bfbb9ff2f", "ctrlclose");
      EnvisionResponse response = client.execute(request);

    	  System.out.println(response.getBody());

  }
}
