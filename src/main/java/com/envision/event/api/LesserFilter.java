package com.envision.event.api;

import java.io.IOException;

public class LesserFilter extends UnaryFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LesserFilter(){}

	public LesserFilter(Column column, String value) {
		super(column, value);
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

}
