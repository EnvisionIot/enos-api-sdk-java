package com.envision.eeop.internal.event;

import java.io.IOException;

public abstract class BinaryFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Filter left;
	private Filter right;

	public BinaryFilter() {
	}

	public BinaryFilter(Filter left, Filter right) {
		if (left == null || right == null) {
			throw new NullPointerException("Please do not pass null");
		}

		this.left = left;
		this.right = right;
	}

	public Filter getLeft() {
		return left;
	}

	public Filter getRight() {
		return right;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);

	}

	public void setLeft(Filter left) {
		this.left = left;
	}

	public void setRight(Filter right) {
		this.right = right;
	}

}
