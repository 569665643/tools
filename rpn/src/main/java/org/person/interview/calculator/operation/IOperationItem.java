package org.person.interview.calculator.operation;

import org.person.interview.calculator.CalculatingContext;
import org.person.interview.calculator.ExpressionItem;

public interface IOperationItem {
    void execute(CalculatingContext context);
    void undo(CalculatingContext context, OperationLog log);

    int getOperandCount();
    ExpressionItem getExpressionItem();
}
