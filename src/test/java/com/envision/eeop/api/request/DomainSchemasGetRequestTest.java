package com.envision.eeop.api.request;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.DomainSchemasGetResponse;

/**
 * Test eeop/mdmService/getObjectAttributes
 * @author jieyuan.shen
 */
public class DomainSchemasGetRequestTest {

	Logger logger = LoggerFactory.getLogger(DomainSchemasGetRequestTest.class);

	private static EnvisionClient client = new EnvisionDefaultClient(
			"http://localhost:8080/eeop",
			"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
			"0E133FBBFC57CA282FC2FC34C6651218");
	
	@Test
	public void testWithoutFields() throws EnvisionApiException {
		List<String> mdmIDList =  Arrays.asList("cbf6fbe9cf234fa3925509d3aec604fa", "9184ddb253464235948ac0c521e964a4");

		DomainSchemasGetRequest request = new DomainSchemasGetRequest(mdmIDList);

		DomainSchemasGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());		
	}
	
	@Test
	public void testWithFields() throws EnvisionApiException {
		List<String> mdmIDList = Arrays.asList("cbf6fbe9cf234fa3925509d3aec604fa", "9184ddb253464235948ac0c521e964a4");
		List<String> fieldList = Arrays.asList("schema", "desc");

		DomainSchemasGetRequest request = new DomainSchemasGetRequest(mdmIDList, fieldList);

		DomainSchemasGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());		
	}
	
}
