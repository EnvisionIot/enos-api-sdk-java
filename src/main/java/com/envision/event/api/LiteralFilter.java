package com.envision.event.api;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LiteralFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  Column column;

	private  Set<String> literals = new HashSet<String>();
	
	public LiteralFilter(){}

	public LiteralFilter(Column column) {
		this.column = column;
	}
	
	public LiteralFilter(Column column,String literals ) {
		if (column==null || literals == null) {
			throw new NullPointerException("Please do not pass null");
		}
		if(!column.isIndex()){
			throw new IllegalArgumentException(
					"This column does not apply to filter because it is not a index type");
		}
		this.column = column;

	}

	public LiteralFilter addLiteral(String literal) {
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
