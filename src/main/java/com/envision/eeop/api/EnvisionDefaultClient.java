package com.envision.eeop.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.exception.EnvisionIOException;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.request.EventQueryRequest;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.Sign;
import com.envision.eeop.api.util.WebUtils;
import com.envision.eos.event.api.bo.EventQuery;
import com.envision.eos.event.api.expression.Column;
import com.envision.eos.event.api.expression.Filter;
import com.envision.eos.event.api.expression.LiteralFilter;
import com.envision.eos.event.api.expression.Order;
import com.envision.eos.event.api.expression.OrderBy;
import com.envision.eos.event.api.expression.Order.OrderEnum;

public class EnvisionDefaultClient implements EnvisionClient {
	private static Logger logger = LoggerFactory
			.getLogger(EnvisionDefaultClient.class);

	private String serverUrl;

	private String appKey;

	private String appSecret;

	// Connect Timeout(ms)
	private int connectTimeout = 30000;

	// Read Timeout(ms)
	private int readTimeout = 30000;

	/**
	 * @param serverUrl
	 * @param appKey
	 * @param appSecret
	 */
	public EnvisionDefaultClient(String serverUrl, String appKey,
			String appSecret) {
		super();
		this.serverUrl = serverUrl;
		this.appKey = appKey;
		this.appSecret = appSecret;
	}

	/**
	 * @param serverUrl
	 * @param appKey
	 * @param appSecret
	 * @param connectTimeout
	 * @param readTimeout
	 */
	public EnvisionDefaultClient(String serverUrl, String appKey,
			String appSecret, int connectTimeout, int readTimeout) {
		super();
		this.serverUrl = serverUrl;
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	@Override
	public <T extends EnvisionResponse> T execute(EnvisionRequest<T> request)
			throws EnvisionApiException {
		return doExecute(request, null);
	}

	@Override
	public <T extends EnvisionResponse> T execute(EnvisionRequest<T> request,
			String token) throws EnvisionApiException {
		return doExecute(request, token);
	}

	protected <T extends EnvisionResponse> T doExecute(
			EnvisionRequest<T> request, String token)
			throws EnvisionApiException {
		try {
			request.check();
		} catch (EnvisionRuleException e) {
			logger.error("Check Parameters Failed!", e);
			throw e;
		}

		return doPost(request, token);
	}

	private <T extends EnvisionResponse> T doPost(EnvisionRequest<T> request,
			String token) throws EnvisionApiException {
		Map<String, String> textParams = request.getTextParams();
		if (token != null && !token.isEmpty()) {
			textParams.put(Constants.TOKEN, token);
		}

		String url = makeUrl(textParams, request.getApiMethodName());
		
		System.out.println(url);
		
		String ret = null;
		try {
			ret = WebUtils.doPost(url, textParams, WebUtils.DEFAULT_CHARSET,
					this.connectTimeout, this.readTimeout);
			logger.debug("result:" + ret);
		} catch (IOException e) {
			logger.error("Execute Post Request Failed!", e);
			throw new EnvisionIOException(e);
		}

		// Parser Response
		T response = JsonParser.fromJson(ret, request.getResponseClass());
		response.setBody(ret);
		logger.debug(response.toString());

		return response;
	}

	private String makeUrl(Map<String, String> textParams, String apiName) {
		// Add sign
		String sign = Sign.sign(appKey, appSecret, textParams);

		// Build Url
		StringBuilder url = new StringBuilder(serverUrl);

		// Make Url
		url.append(apiName);
		url.append("?");
		url.append("appKey=");
		url.append(appKey);
		url.append("&sign=");
		url.append(sign);

		return url.toString();
	}
	
	public static void main(String[] args) throws EnvisionApiException{
		@SuppressWarnings("unused")
        Map<String,String> map=new HashMap<>();
//		String query="{\"selectView\":{\"views\":[\"GLOBAL_ID\",\"DEVICE_ID\",\"CODE\"]},\"start\":\"2017-08-23+00:00:00\",\"end\":\"2017-08-24+00:06:00\",\"timezone\":\"local\",\"filter\":{\"column\":\"SITE_ID\",\"literals\":[\"JSXY.T1_L1.WTG001\"],\"type\":\"LiteralFilter\"},\"s\":0,\"n\":300,\"isShowTotal\":true,\"language\":\"ZH_CN\"}";
//		//String ss="xxx";
// 
//			//query=java.net.URLEncoder.encode("xx","UTF-8");
//			map.put("query", query);
//			map.put("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MDM1NDk5MzcsImNhdGVnb3J5X2xpc3QiOlsiMjEiXSwidXNlcl9pZCI6ImI2YzcyNzZkLWI1NWYtNDFiNy1hMGIzLTFjYjYzNTU0M2U0OSIsImNsaWVudF9pZCI6IjRkMTFiMTI5LWViZTEtNDFlNS04OTkxLWUxNWIyNDAxNThmOSJ9.jEY-VzdUlUXVaGTMbci1yEidCnjN5dyukt3RkhwAB2U");
//			String sign = Sign.sign(appKey, appSecret, map);
//			System.out.println(sign);
		EnvisionDefaultClient client=new EnvisionDefaultClient("http://172.16.33.223:8080/eeop", "xxx","xxx");
		EventQuery query=new EventQuery("1y-ago","now");
		Filter filter=new LiteralFilter(Column.SITE_ID).addLiteral("c5a29074-2a07-4335-9f29-ba751cd82abf");
		query.setFilter(filter);
		query.setOrderBy(new OrderBy().addOrder(new Order(Column.OCCUR_TIME,OrderEnum.DESC)));
		
		EventQueryRequest request =new EventQueryRequest(query);
		
		System.out.println(client.doPost(request, "xxxx").getEventList());

	}
}
