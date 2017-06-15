package com.envision.event.api;

import java.io.IOException;

public class NotRangeFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Column column;

	private String from;

	private String to;

	public NotRangeFilter() {
	}

	public NotRangeFilter(Column column, String from, String to) {
		if (column == null || from == null || to == null) {
			throw new NullPointerException("Please do not pass null");
		}
		if (!column.isIndex()) {
			throw new IllegalArgumentException("This column does not apply to filter because it is not a index type");
		}
		this.column = column;
		this.from = from;
		this.to = to;
	}

	public Column getColumn() {
		return column;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);

	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
