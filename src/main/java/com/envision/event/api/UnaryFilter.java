package com.envision.event.api;

public abstract class UnaryFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Column column;

	private String value;

	public UnaryFilter() {
	}

	public Column getColumn() {

		return column;
	}

	public String getValue() {
		return value;
	}

	public UnaryFilter(Column column, String value) {
		if (column == null || value == null) {
			throw new NullPointerException("Please do not pass null");
		}

		if (!column.isIndex()) {
			throw new IllegalArgumentException("This column does not apply to filter because it is not a index type");
		}
		this.column = column;
		this.value = value;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
