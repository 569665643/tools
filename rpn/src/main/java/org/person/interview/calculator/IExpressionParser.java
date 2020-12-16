package org.person.interview.calculator;

import org.person.interview.calculator.operation.IOperationItem;

import java.util.List;

public interface IExpressionParser {
    List<IOperationItem> getExpression(Expression expression);
}
