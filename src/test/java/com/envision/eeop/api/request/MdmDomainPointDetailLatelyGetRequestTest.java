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
import com.envision.eeop.api.response.MdmDomainPointsDetailGetResponse;

/**
 * TODO Comment of MdmDomainPointsGetRequestTest
 *
 */
public class MdmDomainPointDetailLatelyGetRequestTest {
	Logger logger = LoggerFactory
			.getLogger(MdmDomainPointDetailLatelyGetRequestTest.class);

	private static EnvisionClient client = new EnvisionDefaultClient(
			"http://localhost:8080/eeop",
			"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
			"0E133FBBFC57CA282FC2FC34C6651218");

	@Test
	public void testRequest() throws EnvisionApiException {
		List<String> fieldList = Arrays.asList("value", "timestamp");
		MdmDomainPointDetailLatelyGetRequest request = new MdmDomainPointDetailLatelyGetRequest(
				"6e2dcedf64334782a8abb03a5a963e33", "WTUR.TurbineUnionSts",
				fieldList);

		MdmDomainPointsDetailGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());
	}
}
