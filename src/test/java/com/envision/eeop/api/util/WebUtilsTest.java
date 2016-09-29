/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/
 * All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web Util Test
 *
 */
public class WebUtilsTest {
	private static Logger logger = LoggerFactory.getLogger(WebUtilsTest.class);
	
	@Test
	public void testDoGet() throws Exception {
		String url = "http://localhost:8080/eeop/pointService/getDevicePoint";
		String contents = "appKey=8a7d6f2e-1fde-4543-b9d8-fc8f070451e6&deviceID=9a30c6485b654f46890578089287b176&pointIDList=INV.CurDCIn,INV.State&sign=241D138BF60DBAB3808791E3D3E8919A18FD8F3F";

		logger.info(WebUtils.doGet(url, contents, "UTF-8"));

	}
	
	@Test
	public void testDoPost() throws Exception {
		String url = "http://localhost:8080/eeop/pointService/getDevicePoint";
		String ctype = "application/x-www-form-urlencoded;charset=" + "UTF-8";
		String contents = "appKey=8a7d6f2e-1fde-4543-b9d8-fc8f070451e6&deviceID=9a30c6485b654f46890578089287b176&pointIDList=INV.CurDCIn,INV.State&sign=241D138BF60DBAB3808791E3D3E8919A18FD8F3F";

		logger.info(WebUtils.doPost(url, ctype, contents.getBytes(),
				30000, 30000));

	}
}
