package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DimensionsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DimensionFindByKeysRequest implements
		EnvisionRequest<DimensionsGetResponse> {
	private static final String API_METHOD = "/dimension/findByKeys";

	private String mdmid; // mandatory

	private String table; // mandatory

	private String keys; // mandatory

	/**
	 * @param mdmid
	 * @param table
	 * @param keys
	 */
	public DimensionFindByKeysRequest(String mdmid, String table, List<String> keys) {
		super();
		this.mdmid = mdmid;
		this.table = table;
		this.keys = StringUtils.listToString(keys, ',');;
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

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
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
		txtParams.put("keys", keys);

		return txtParams;
	}

	@Override
	public Class<DimensionsGetResponse> getResponseClass() {
		return DimensionsGetResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
		RuleCheckUtils.checkNotEmpty(table, "table");
		RuleCheckUtils.checkNotEmpty(keys, "keys");
	}
}
