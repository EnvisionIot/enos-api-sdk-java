package com.envision.event.api;

import java.io.IOException;

public class Aggregate implements Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum AggregateType {
		AVG("AVG"), SUM("SUM"), MAX("MAX"), MIN("MIN"), COUNT("COUNT");
		private String name;

		AggregateType(String s) {
			name = s;
		}

		public String toString() {
			return name;
		}

	}

	private Column column;

	private AggregateType aggregateType;

	public Aggregate() {
	}

	public Aggregate(AggregateType aggregateType, Column column) {

		if (aggregateType == null || column == null) {
			throw new NullPointerException("Please do not pass null");
		}
		if (aggregateType != AggregateType.COUNT && !column.isNumber()) {
			throw new IllegalArgumentException(
					"This column does not apply to aggregate functions because it is not a numeric type");
		}
		this.column = column;
		this.aggregateType = aggregateType;
	}

	public Column getColumn() {
		return column;
	}

	public AggregateType getAggregateType() {
		return aggregateType;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);

	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public void setAggregateType(AggregateType aggregateType) {
		this.aggregateType = aggregateType;
	}

}
