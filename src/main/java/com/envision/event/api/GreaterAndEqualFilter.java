package com.envision.event.api;

import java.io.IOException;

public class GreaterAndEqualFilter extends UnaryFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GreaterAndEqualFilter() {
		super();
	}

	public GreaterAndEqualFilter(Column column, String value) {
		super(column, value);
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

}
