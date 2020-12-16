package org.person.interview.calculator.operation;

import org.person.interview.calculator.ExpressionItem;

import java.util.List;

public class Operand extends AbstractOperationItem {

    public Operand(ExpressionItem item) {
        super(item);
    }


    @Override
    protected Operand doExecute(List<Operand> operands) {
        return operationItemFactory.createOperand(super.expressionItem);
    }

    @Override
    public int getOperandCount() {
        return 0;
    }
}
