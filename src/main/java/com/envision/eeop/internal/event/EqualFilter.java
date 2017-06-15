package com.envision.eeop.internal.event;

import java.io.IOException;

public class EqualFilter extends UnaryFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EqualFilter() {
		super();
	}

	public EqualFilter(Column column, String value) {

		super(column, value);

	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

}
