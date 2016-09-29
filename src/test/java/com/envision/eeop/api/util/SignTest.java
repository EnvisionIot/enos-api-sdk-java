/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sign Test
 */
public class SignTest {
	Logger logger  = LoggerFactory.getLogger(SignTest.class);
	
	private String appKey;
	private String secret;
	private Map<String, String> paramMap;
	
	{
		paramMap = new HashMap<String, String>();
		paramMap.put("a", "1111");
		paramMap.put("b","你好");
		
		appKey = "test";
		secret = "secret";
	}
	
	@Test
	public void testDefaultSign() {
		String sign = Sign.sign(appKey, secret, paramMap);
		logger.info(sign);
		assertEquals(sign, "59E640765C47390E5B7431AD0E1B576E3414E2B3");
	}

}
