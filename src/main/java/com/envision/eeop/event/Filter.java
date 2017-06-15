package com.envision.eeop.event;

public abstract class Filter implements Expression {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final  String type = this.getClass().getSimpleName();

	public AndFilter and(Filter filter) {

		return new AndFilter(this, filter);
	}

	public OrFilter or(Filter filter) {

		return new OrFilter(this, filter);
	}

	public String getType() {
		return type;
	}

}
