package com.envision.eeop.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderBy implements Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Order> orders = new ArrayList<Order>();

	public OrderBy() {

	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderBy addOrder(Order order) {
		if (order == null) {
			throw new NullPointerException("Please do not pass null");
		}
		orders.add(order);
		return this;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

	public List<Order> getOrders() {
		return orders;
	}

}
