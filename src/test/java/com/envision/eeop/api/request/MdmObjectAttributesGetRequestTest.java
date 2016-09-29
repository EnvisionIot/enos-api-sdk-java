package com.envision.eeop.api.request;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.MdmObjectAttributesGetResponse;

/**
 * Test eeop/mdmService/getObjectAttributes
 * @author jieyuan.shen
 */
public class MdmObjectAttributesGetRequestTest {

	Logger logger = LoggerFactory.getLogger(MdmObjectAttributesGetRequestTest.class);

	private static EnvisionClient client = new EnvisionDefaultClient(
			"http://localhost:8080/eeop",
			"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
			"0E133FBBFC57CA282FC2FC34C6651218");
	
	@Test
	public void testWithoutAttributes() throws EnvisionApiException {
		List<String> mdmIDList =  Arrays.asList("a77502ba622942658ca116cef5b8cf6c","a4755fbcbc4548ed82ffa33ce34c0539");

		MdmObjectAttributesGetRequest request = new MdmObjectAttributesGetRequest(
				mdmIDList);

		MdmObjectAttributesGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());		
	}

	@Test
	public void testWithAttributes() throws EnvisionApiException {
		List<String> mdmIDList =  Arrays.asList("a77502ba622942658ca116cef5b8cf6c","a4755fbcbc4548ed82ffa33ce34c0539");
		List<String> attributeList = Arrays.asList("name", "branches");
				
		MdmObjectAttributesGetRequest request = new MdmObjectAttributesGetRequest(
				mdmIDList, attributeList);

		MdmObjectAttributesGetResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println(response.toString());		
	}
}
