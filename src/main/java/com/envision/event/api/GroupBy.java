package com.envision.event.api;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GroupBy implements Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Column> columns = new HashSet<Column>();

	public GroupBy() {

	}

	public void setColumns(Set<Column> columns) {
		this.columns = columns;
	}

	public Set<Column> getColumns() {
		return columns;
	}


	public GroupBy addColumn(Column column) {

		if (column == null) {
			throw new NullPointerException("Please do not pass null");
		}
		columns.add(column);
		return this;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

}
