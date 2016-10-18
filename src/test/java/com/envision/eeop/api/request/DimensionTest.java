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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.response.CountGetResponse;
import com.envision.eeop.api.response.DimensionGetResponse;
import com.envision.eeop.api.response.DimensionsGetResponse;

/**
 * TODO Comment of DoaminControlTest
 *
 */
public class DimensionTest {
	private final static String GATEWAY = "http://localhost:8080/eeop";

	// private final static String GATEWAY = "http://10.21.10.12:8080/eeop";
	//private final static String GATEWAY = "http://172.16.33.223:8080/eeop";

	@Test
	public void testFindByColumns() throws EnvisionApiException {
		EnvisionClient client = new EnvisionDefaultClient(GATEWAY,
				"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
				"0E133FBBFC57CA282FC2FC34C6651218");

		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("a", 1);
		map.put("description", "维护停机");

		DimensionFindByColumnsRequest request = new DimensionFindByColumnsRequest(
				"57baab592b0f1cfd669469d2", "standardstate", map);
		DimensionsGetResponse response = client.execute(request);
		if (response.isSuccess()) {
			System.out.println(response.getDimensions());
		}
	}

	@Test
	public void testInsert() throws EnvisionApiException {
		EnvisionClient client = new EnvisionDefaultClient(GATEWAY,
				"a0720bb5-916c-43e2-b8e4-b129cfaf8bb6",
				"0E133FBBFC57CA282FC2FC34C6651218");

		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("a", 1);
		map.put("description", "维护停机");


		DimensionInsertRequest request = new DimensionInsertRequest("111111",
				"57baab592b0f1cfd669469d2", "standardstate", map);
		EnvisionResponse response = client.execute(request);
		System.out.println(response.getBody());

	}

	@Test
	public void testFindByKey() throws EnvisionApiException {
		EnvisionClient client = new EnvisionDefaultClient(GATEWAY,
				"EEOP_TEST",
				"0E133FBBFC57CA282FC2FC34C6651218");

		DimensionFindByKeyRequest request = new DimensionFindByKeyRequest(
				"57baab592b0f1cfd669469d2", "standardstate", "285e485ec6c14888a25ed20cf5239087");
		DimensionGetResponse response = client.execute(request, "zzz");
		System.out.println(response.getBody());
	}
	
	@Test
	public void testFindByKeys() throws EnvisionApiException {
		EnvisionClient client = new EnvisionDefaultClient(GATEWAY,
				"EEOP_TEST",
				"0E133FBBFC57CA282FC2FC34C6651218");
		
		List<String> keys = new ArrayList<>();
		keys.add("id5");
		keys.add("id6");
		DimensionFindByKeysRequest request = new DimensionFindByKeysRequest(
				"111111", "test1", keys);
		DimensionsGetResponse response = client.execute(request, "zzz");
		System.out.println(response.getBody() + ":" + response.toString());
	}
	
	@Test
	public void testDeleteByKey() throws EnvisionApiException {
		EnvisionClient client = new EnvisionDefaultClient(GATEWAY,
				"EEOP_TEST",
				"0E133FBBFC57CA282FC2FC34C6651218");

		DimensionDeleteByKeyRequest request = new DimensionDeleteByKeyRequest(
				"111111", "test1", "id5");
		CountGetResponse response = client.execute(request, "zzz");
		System.out.println(response.getBody()  + ":" + response.toString());
	}
}
