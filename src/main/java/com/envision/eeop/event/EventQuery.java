package com.envision.eeop.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class EventQuery implements Element {

	private static final long serialVersionUID = 1L;

	private View selectView;

	private String start;
	private String end;
	/**
	 * "local":表示当地时间 "utc":表示utc时间
	 */
	private String timezone;

	private Filter filter;

	private OrderBy orderBy;

	private List<Aggregate> aggregates;

	private GroupBy groupBy;

	/**
	 * 开始记录数
	 */
	private int s = 0;
	/**
	 * 截至记录数
	 */
	private int n = 20;
	/**
	 * 是否返回记录数
	 */
	private boolean isShowTotal;
	/**
	 * 查询告警类型 0：所有告警 1: 只确认的告警 2：非确认的告警
	 */
	private ConfirmType confirmType;
	
	/**
	 * 查询是否是进行中告警
	 */
	private boolean isAlarming;

	/**
	 * 默认为中文
	 */
	private LanguageType language;

	public EventQuery() {

	}

	public EventQuery(String start) {
		this(start, "now");
	}

	/**
	 * 告警查询
	 * <p>
	 * 可以支持多种格式的时间
	 * <ul>
	 * <li>{@code now}: 当前时间</li>
	 * <li>{@code xxxs-ago}: xxx秒之前</li>
	 * <li>{@code xxxm-ago}: xxx分钟之前</li>
	 * <li>{@code xxxh-ago}: xxx小时之前</li>
	 * <li>{@code xxxd-ago}: xxx天之前</li>
	 * <li>{@code xxxw-ago}: xxx周之前</li>
	 * <li>{@code xxxn-ago}: xxx月之前 (30 天)</li>
	 * <li>{@code xxxy-ago}: xxx年之前 (365 天)</li>
	 * <li>{@code yyyy-MM-dd HH:mm:ss}: 当地的具体日期时间</li>
	 * </ul>
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间.
	 */
	public EventQuery(String start, String end) {
		this(start, end, "local");
	}

	/**
	 * 告警查询
	 * <p>
	 * 可以支持多种格式的时间
	 * <ul>
	 * <li>{@code now}: 当前时间</li>
	 * <li>{@code xxxm-ago}: xxx毫秒之前</li>
	 * <li>{@code xxxs-ago}: xxx秒之前</li>
	 * <li>{@code xxxm-ago}: xxx分钟之前</li>
	 * <li>{@code xxxh-ago}: xxx小时之前</li>
	 * <li>{@code xxxd-ago}: xxx天之前</li>
	 * <li>{@code xxxw-ago}: xxx周之前</li>
	 * <li>{@code xxxn-ago}: xxx月之前 (30 天)</li>
	 * <li>{@code xxxy-ago}: xxx年之前 (365 天)</li>
	 * <li>{@code yyyy-MM-dd HH:mm:ss}: 在timezone设定下的具体日期时间</li>
	 * </ul>
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间.
	 * @param timezone
	 *            设置时区. "UTC": utc时区，"LOCAL": 当地时区
	 */
	public EventQuery(String start, String end, String timezone) {
		this.start = start;
		this.end = end;
		this.timezone = timezone;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public LanguageType getLanguage() {
		if (language != null) {
			return language;
		}
		return LanguageType.ZH_CN;
	}

	public boolean isAlarming() {
		return isAlarming;
	}

	public void setAlarming(boolean isAlarming) {
		this.isAlarming = isAlarming;
	}

	public EventQuery addAggregate(Aggregate aggregate) {
		if (aggregate == null) {
			throw new NullPointerException("Please do not pass null");
		}
		if (aggregates == null) {
			aggregates = new ArrayList<Aggregate>();
		}
		aggregates.add(aggregate);
		return this;
	}

	public void setGroupBy(GroupBy groupBy) {
		this.groupBy = groupBy;
	}

	public void setAggregates(List<Aggregate> aggregates) {
		this.aggregates = aggregates;
	}

	public List<Aggregate> getAggregates() {
		return aggregates;
	}

	public GroupBy getGroupBy() {
		return groupBy;
	}

	public void setLanguage(LanguageType language) {

		this.language = language;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public String getTimezone() {
		return timezone;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public OrderBy getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(OrderBy orderBy) {

		this.orderBy = orderBy;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public boolean isShowTotal() {
		return isShowTotal;
	}

	public void setShowTotal(boolean isShowTotal) {
		this.isShowTotal = isShowTotal;
	}

	public ConfirmType getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(ConfirmType queryType) {

		this.confirmType = queryType;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);

	}

	public View getSelectView() {
		return selectView;
	}

	public void setSelectView(View selectView) {
		this.selectView = selectView;
	}

}
