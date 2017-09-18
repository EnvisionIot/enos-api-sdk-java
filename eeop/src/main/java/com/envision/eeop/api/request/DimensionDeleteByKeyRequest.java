package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.CountGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DimensionDeleteByKeyRequest implements
		EnvisionRequest<CountGetResponse> {
	private static final String API_METHOD = "/dimension/deleteByKey";

	private String mdmid; // mandatory

	private String table; // mandatory

	private String key; // mandatory

	/**
	 * @param mdmid
	 * @param table
	 * @param key
	 */
	public DimensionDeleteByKeyRequest(String mdmid, String table, String key) {
		super();
		this.mdmid = mdmid;
		this.table = table;
		this.key = key;
	}

	public String getMdmid() {
		return mdmid;
	}

	public void setMdmid(String mdmid) {
		this.mdmid = mdmid;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String getApiMethodName() {
		return API_METHOD;
	}

	@Override
	public Map<String, String> getTextParams() {
		EnvisionHashMap txtParams = new EnvisionHashMap();

		txtParams.put("mdmid", mdmid);
		txtParams.put("table", table);
		txtParams.put("key", key);

		return txtParams;
	}

	@Override
	public Class<CountGetResponse> getResponseClass() {
		return CountGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
		RuleCheckUtils.checkNotEmpty(table, "table");
		RuleCheckUtils.checkNotEmpty(key, "key");
	}
}
