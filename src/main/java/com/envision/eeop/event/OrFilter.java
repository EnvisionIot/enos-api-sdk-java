package com.envision.eeop.event;

import java.io.IOException;

public class OrFilter extends BinaryFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrFilter() {
		super();
	}

	public OrFilter(Filter left, Filter right) {
		super(left, right);
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

}
