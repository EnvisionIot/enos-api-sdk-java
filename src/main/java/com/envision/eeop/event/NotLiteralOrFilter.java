package com.envision.eeop.event;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class NotLiteralOrFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Column column;

	private Set<String> literals = new HashSet<String>();

	public NotLiteralOrFilter() {
	}

	public NotLiteralOrFilter(Column column) {
		if (column == null) {
			throw new IllegalArgumentException("Please do not pass null");
		}
		if (!column.isIndex()) {
			throw new IllegalArgumentException("This column does not apply to filter because it is not a index type");
		}
		this.column = column;
	}

	public NotLiteralOrFilter addLiteral(String literal) {
		if (literal == null) {
			throw new NullPointerException("Please do not pass null");
		}
		literals.add(literal);
		return this;
	}

	public Column getColumn() {
		return column;
	}

	public Set<String> getLiterals() {
		return literals;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public void setLiterals(Set<String> literals) {
		this.literals = literals;
	}
	
	

}
