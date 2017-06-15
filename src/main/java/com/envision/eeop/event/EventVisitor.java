package com.envision.eeop.event;

import java.io.IOException;

public abstract class EventVisitor {

	public abstract void visit(EventQuery alarmQuery) throws IOException;

	public abstract void visit(AndFilter andFilter) throws IOException;

	public abstract void visit(OrFilter orFilter) throws IOException;

	public abstract void visit(RangeFilter rangeFilter) throws IOException;

	public abstract void visit(LiteralFilter filter) throws IOException;;

	public abstract void visit(OrderBy orderBy) throws IOException;

	public abstract void visit(Aggregate aggregate) throws IOException;

	public abstract void visit(GroupBy groupBy) throws IOException;

	public abstract void visitExpression(Expression e) throws IOException;

	public abstract void visit(GreaterFilter greaterFilter) throws IOException;

	public abstract void visit(EqualFilter equalFilter) throws IOException;

	public abstract void visit(GreaterAndEqualFilter greaterAndEqualFilter) throws IOException;

	public abstract void visit(LesserAndEqualFilter lessAndEqualFilter) throws IOException;

	public abstract void visit(LesserFilter lesserFilter) throws IOException;

	public abstract void visit(Order order) throws IOException;

	public abstract void visit(NotEqualFilter notEqualFilter) throws IOException;

	public abstract void visit(NotRangeFilter notRangeFilter) throws IOException;

	public abstract void visit(NotLiteralOrFilter notLiteralOrFilter) throws IOException;

	public abstract void visit(IsNullFilter isNullFilter) throws IOException;

	public abstract void visit(IsNotNullFilter isNotNullFilter) throws IOException;

	public abstract void visit(MatchFilter filter) throws IOException;

	public void visit(Filter filter) throws IOException {

	}

	public abstract void visit(View view) throws IOException;

}
