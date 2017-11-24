package com.envision.eeop.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.domain.CloudedgeDevice;
import com.envision.eeop.api.exception.EnvisionApiException;
import com.envision.eeop.api.exception.EnvisionIOException;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.request.CloudedgeAttachDeviceRequest;
import com.envision.eeop.api.request.CloudedgeDetachDeviceRequest;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.Sign;
import com.envision.eeop.api.util.WebUtils;

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws EnvisionApiException{
		@SuppressWarnings("unused")
        Map<String,String> map=new HashMap<>();
		EnvisionDefaultClient client=new EnvisionDefaultClient("http://10.21.10.13:8080/eeop", "EEOP_TEST","xxx");
//		EventQuery query=new EventQuery("1y-ago","now");
//		Filter filter=new LiteralFilter(Column.SITE_ID).addLiteral("c5a29074-2a07-4335-9f29-ba751cd82abf");
//		query.setFilter(filter);
//		query.setOrderBy(new OrderBy().addOrder(new Order(Column.OCCUR_TIME,OrderEnum.DESC)));
//		
//		EventQueryRequest request =new EventQueryRequest(query);
//		
//		System.out.println(client.doPost(request, "xxxx").getEventList());
//		CloudedgeAppGetRequest request=new CloudedgeAppGetRequest("57baab5ed3eb4806104b045d");
//		
//		CloudedgeAppGetResponse reponse = client.doPost(request, "xxxx");
		
		List<CloudedgeDevice> ds =new ArrayList<>();
		CloudedgeDevice d1=new CloudedgeDevice("19ebba76e6800000",1100,new HashMap());
		ds.add(d1);
		
		CloudedgeAttachDeviceRequest attachrequest=new CloudedgeAttachDeviceRequest("57baab5ed3eb4806104b045d","edge-1511493159229-00033",ds);
		client.doPost(attachrequest, "xxx");
		
//		CloudedgeDetachDeviceRequest detachrequest=new CloudedgeDetachDeviceRequest("287774c7-881c-4b5b-850d-9240bbb96fb2","edge-1511247419758-00015");
//		client.doPost(detachrequest, "xxx");

	}
}
