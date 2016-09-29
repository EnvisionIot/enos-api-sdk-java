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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmIdsGetResponse;

/**
 * TODO Comment of MdmDomainPointsGetRequestTest
 *
 */
public class MdmIDsByValueGetRequestTest {
	Logger logger = LoggerFactory.getLogger(MdmIDsByValueGetRequestTest.class);

	private static EnvisionClient client = new EnvisionDefaultClient(
			"http://localhost:8080/eeop",
			"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
			"0E133FBBFC57CA282FC2FC34C6651218");
	
	@Test
	public void getGet() throws EnvisionApiException {
		MdmIDsByValueGetRequest request = new MdmIDsByValueGetRequest("9184ddb253464235948ac0c521e964a4", 207,
				"CBX.State", "1");
		MdmIdsGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		if (response == null || response.getMdmIDList() == null) {
			System.out.println("Get Fail!");
		} else {
			System.out.println(response.getMdmIDList().toString());
		}
			
	}
}
