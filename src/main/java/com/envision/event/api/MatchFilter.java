package com.envision.event.api;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.envision.event.api.Column.DataType;

public class MatchFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Column firstColumn;

	private Set<Column> otherColumns = new HashSet<Column>();

	private Set<String> texts = new HashSet<String>();

	public MatchFilter() {
	}

	public MatchFilter(Column column) {

		if (column == null) {
			throw new NullPointerException("Please do not pass null");
		}
		if (column.getDataType() != DataType.STRING || !column.isFullIndex()) {
			throw new IllegalArgumentException("This column does not apply to full index filter");
		}
		this.firstColumn = column;
	}

	public Column getFirstColumn() {
		return firstColumn;
	}

	public Set<String> getTexts() {
		return texts;
	}

	public MatchFilter addOtherColumn(Column column) {
		if (column == null) {
			throw new NullPointerException("Please do not pass null");
		}
		if (column.getDataType() != DataType.STRING || !column.isFullIndex()) {
			throw new IllegalArgumentException("This column does not apply to full index filter");
		}

		if (column == firstColumn) {
			throw new IllegalArgumentException("you add the same column again :)");
		}
		otherColumns.add(column);

		return this;
	}

	public MatchFilter addLiteral(String literal) {
		if (literal == null) {
			throw new NullPointerException("Please do not pass null");
		}
		texts.add(literal);
		return this;
	}

	public Set<Column> getOtherColumns() {
		return otherColumns;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

	public void setFirstColumn(Column firstColumn) {
		this.firstColumn = firstColumn;
	}

	public void setOtherColumns(Set<Column> otherColumns) {
		this.otherColumns = otherColumns;
	}

	public void setTexts(Set<String> texts) {
		this.texts = texts;
	}

}
