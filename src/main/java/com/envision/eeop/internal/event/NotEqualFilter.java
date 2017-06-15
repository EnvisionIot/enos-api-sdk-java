package com.envision.eeop.internal.event;

import java.io.IOException;

public class NotEqualFilter extends UnaryFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEqualFilter() {
	}

	public NotEqualFilter(Column column, String value) {
		super(column, value);
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

}
