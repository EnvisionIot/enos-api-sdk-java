/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.request;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmDomainPointsDetailGetResponse;

/**
 * TODO Comment of MdmDomainServiceTest
 *
 */
public class MdmDomainServiceTest {
	//private final static String GATEWAY = "http://localhost:8080/eeop/";
	// private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
	private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

	@Test
	public void testGetDomainDetail() throws EnvisionApiException {
	      EnvisionClient client = new EnvisionDefaultClient(
	              GATEWAY,
	              "a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
	              "0E133FBBFC57CA282FC2FC34C6651218");
		
		String beginTime = "2016-08-23 16:24:25";
		String endTime = "2016-08-23 16:44:51";
		MdmDomainPointDetailGetRequest request = new MdmDomainPointDetailGetRequest(
				"5a622e333f9d46af9f52eb913133dd14", "INV.PVPowIn",
				beginTime, endTime);
		request.setBoundaryFlag(1);
		List<String> fieldList = new ArrayList<>();
		fieldList.add("value");
		fieldList.add("timestamp");
		request.setFieldList(fieldList);
		
		MdmDomainPointsDetailGetResponse response  = client.execute(request);
		
		System.out.println(response.getBody());
		
	}

}
