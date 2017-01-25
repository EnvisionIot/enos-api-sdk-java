package com.envision.eeop.api.request;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectsGetResponse;

/**
 * Test eeop/mdmService/getObjectAttributes
 * @author jieyuan.shen
 */
public class MdmObjectsGetRequestTest {

	Logger logger = LoggerFactory.getLogger(MdmObjectsGetRequestTest.class);

	private static EnvisionClient client = new EnvisionDefaultClient(
			"http://localhost:8080/eeop",
			"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
			"0E133FBBFC57CA282FC2FC34C6651218");
	
	@Test
	public void testWithoutTypesAndAttributes() throws EnvisionApiException {
		List<String> mdmIDList =  Arrays.asList("cbf6fbe9cf234fa3925509d3aec604fa");

		MdmObjectsGetRequest request = new MdmObjectsGetRequest(mdmIDList);

		MdmObjectsGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());		
	}

	@Test
	public void testWithTypes() throws EnvisionApiException {
		List<String> mdmIDList =  Arrays.asList("9184ddb253464235948ac0c521e964a4");
		List<String> typeList = Arrays.asList("206", "208");

		MdmObjectsGetRequest request = new MdmObjectsGetRequest(mdmIDList, typeList, null);

		MdmObjectsGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());		
	}
	
	@Test
	public void testWithTypesAndAttributes() throws EnvisionApiException {
		List<String> mdmIDList =  Arrays.asList("WF0024WTG0001,WF0024");
		List<String> typeList = Arrays.asList("58");
		List<String> attributeList = Arrays.asList("name", "timezone");

		MdmObjectsGetRequest request = new MdmObjectsGetRequest(
		        mdmIDList, typeList, attributeList, Locale.CHINA.toString());
		MdmObjectsGetResponse response = client.execute(request, "token-white-line");
		
		// How to get name:
		System.out.println(response.getMdmChildObjects()
		        .get("WF0024WTG0001").getAttributes().get("name"));
		// How to get timezone:
		System.out.println(response.getMdmChildObjects()
		        .get("WF0024WTG0001").getMdmObjectList().get("58")
		        .iterator().next().getAttributes().get("timezone"));
	}
}
