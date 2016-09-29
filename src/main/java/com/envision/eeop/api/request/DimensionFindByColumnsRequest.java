package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.DimensionsGetResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.JsonParser;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DimensionFindByColumnsRequest implements
		EnvisionRequest<DimensionsGetResponse> {
	private static final String API_METHOD = "/dimension/findByColumns";

	private String mdmid; // mandatory

	private String table; // mandatory

	private String columnFilters;

	/**
	 * @param mdmid
	 * @param table
	 * @param columns
	 */
	public DimensionFindByColumnsRequest(String mdmid, String table,
			Map<String, Object> columns) {
		super();
		this.mdmid = mdmid;
		this.table = table;
		columnFilters = JsonParser.toJson(columns);

		// List<String> filters = new ArrayList<String>();
		// for (String filter: columns.keySet()) {
		// filters.add(filter + ":\"" + columns.get(filter));
		// }
		// if (!filters.isEmpty()) {
		// filterList = StringUtils.listToString(filters, "\",");
		// filterList = filterList.concat("\"");
		// } else {
		// filterList = "";
		// }
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

	public String getColumnFilters() {
		return columnFilters;
	}

	public void setColumnFilters(String columnFilters) {
		this.columnFilters = columnFilters;
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
		txtParams.put("columnFilters", columnFilters);

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
		RuleCheckUtils.checkNotEmpty(columnFilters, "columnFilters");
	}
}
