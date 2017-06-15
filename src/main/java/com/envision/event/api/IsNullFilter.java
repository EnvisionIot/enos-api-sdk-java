package com.envision.event.api;

import java.io.IOException;

public class IsNullFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Column column;

	public IsNullFilter() {
	}

	public IsNullFilter(Column column) {
		if (column == null) {
			throw new NullPointerException("Please do not pass null");
		}
		if (!column.isIndex()) {
			throw new IllegalArgumentException("This column does not apply to filter because it is not a index type");
		}
		this.column = column;
	}

	public Column getColumn() {
		return column;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

	public void setColumn(Column column) {
		this.column = column;
	}
	
	

}
