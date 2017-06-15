package com.envision.event.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class View implements Expression {

	private List<Column> views = new ArrayList<Column>();

	public View() {
	};

	public View addColumnView(Column c) {
		views.add(c);
		return this;
	}

	public void accept(EventVisitor visitor) throws IOException {
		visitor.visit(this);

	}

	public List<Column> getColumnView() {
		return views;
	}

}
