package com.envision.eeop.internal.event;

import java.io.IOException;

public class Order implements Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum OrderEnum {
		ASC("asc"), DESC("desc");

		private final String codeVal;

		OrderEnum(String codeVal) {
			this.codeVal = codeVal;
		}

		@Override
		public String toString() {
			return String.valueOf(codeVal);
		}
	}

	private Column column;

	private OrderEnum order;

	public Order() {
	}

	public Order(Column column, OrderEnum order) {
		if (column == null || order == null) {
			throw new NullPointerException("Please do not pass null");
		}
		this.column = column;
		this.order = order;
	}

	public Column getColumn() {
		return column;
	}

	public OrderEnum getOrder() {
		return order;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public void setOrder(OrderEnum order) {
		this.order = order;
	}

}
