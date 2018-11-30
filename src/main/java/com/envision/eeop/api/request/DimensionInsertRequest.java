package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DimensionInsertRequest implements
		EnvisionRequest<EnvisionResponse> {
	private static final String API_METHOD = "/dimension/insert";

	private String mdmid; // mandatory

	private String table; // mandatory

	private String key; // optional

	private String columns; // mandatory

	public DimensionInsertRequest(String mdmid, String table, String key,
			Map<String, Object> columnMap) {
		this(mdmid, table, columnMap);
		this.key = key;
	}

	public DimensionInsertRequest(String mdmid, String table,
			Map<String, Object> columnMap) {
		super();
		this.mdmid = mdmid;
		this.table = table;
		this.columns = JsonParser.toJson(columnMap);
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

	public String getColumns() {
		return columns;
	}

	/**
	 * @deprecated use {@link #getColumns()} instead
	 */
	public String getColumes() {
		return getColumns();
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	/**
	 * @deprecated use {@link #setColumns(String)} instead
	 */
	public void setColumes(String columes) {
	    setColumns(columes);
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
		if (!StringUtils.isEmpty(key)) {
			txtParams.put("key", key);
		}
		txtParams.put("columns", columns);
		// TODO deprecated parameters
		txtParams.put("columes", columns);

		return txtParams;
	}

	@Override
	public Class<EnvisionResponse> getResponseClass() {
		return EnvisionResponse.class;
	}

	@Override
	public void check() throws EnvisionRuleException {
		RuleCheckUtils.checkNotEmpty(mdmid, "mdmid");
		RuleCheckUtils.checkNotEmpty(table, "table");
		RuleCheckUtils.checkNotEmpty(columns, "columns");
	}
}
