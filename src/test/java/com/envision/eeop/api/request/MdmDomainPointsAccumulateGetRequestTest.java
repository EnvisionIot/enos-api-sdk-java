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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmDomainPointsValueGetResponse;

/**
 * TODO Comment of MdmDomainPointsAccumulateGetRequestTest
 *
 */
public class MdmDomainPointsAccumulateGetRequestTest {
	Logger logger = LoggerFactory.getLogger(MdmDomainPointsGetRequestTest.class);

	private static EnvisionClient client = new EnvisionDefaultClient(
			"http://localhost:8080/eeop",
			"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
			"0E133FBBFC57CA282FC2FC34C6651218");
	
	@Test
	public void testWithFields() throws EnvisionApiException {
		List<String> pointIDList =  Arrays.asList("INV.CosPhi", "INV.State", "Curly");
		List<String> deviceIDList = Arrays.asList("70106f0c458e4b3994e741670d6be659","9a30c6485b654f46890578089287b176");		
				
		MdmDomainPointsAccumulateGetRequest request = new MdmDomainPointsAccumulateGetRequest(deviceIDList, pointIDList, "D");

		MdmDomainPointsValueGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());		
	}
}
