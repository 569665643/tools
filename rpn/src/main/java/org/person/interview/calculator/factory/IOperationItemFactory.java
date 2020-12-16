package org.person.interview.calculator.factory;

import org.person.interview.calculator.operation.AbstractOperationItem;
import org.person.interview.calculator.ExpressionItem;
import org.person.interview.calculator.operation.IOperationItem;
import org.person.interview.calculator.operation.Operand;

import java.math.BigDecimal;

public interface IOperationItemFactory {
    Operand createOperand(String value);
    Operand createOperand(BigDecimal value);
    Operand createOperand(ExpressionItem item);

    IOperationItem createOperator(ExpressionItem item);
}
