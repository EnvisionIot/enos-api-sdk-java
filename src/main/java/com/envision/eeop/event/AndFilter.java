package com.envision.eeop.event;

import java.io.IOException;

public class AndFilter extends BinaryFilter {
	private static final long serialVersionUID = 1L;

	public AndFilter() {
		super();
	}

	public AndFilter(Filter left, Filter right) {
		super(left, right);
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);

	}

}
