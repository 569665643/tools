package org.person.interview.calculator.operation;

import org.person.interview.calculator.CalculatingContext;
import org.person.interview.calculator.ExpressionItem;
import org.person.interview.calculator.exception.InvalidException;

public class InvalidOperationItem implements IOperationItem{

    private ExpressionItem item;
    public InvalidOperationItem(ExpressionItem item){
        this.item = item;
    }

    @Override
    public void execute(CalculatingContext context) {
        throw new InvalidException();
    }

    @Override
    public void undo(CalculatingContext context, OperationLog log) {

    }

    @Override
    public int getOperandCount() {
        return 0;
    }

    @Override
    public ExpressionItem getExpressionItem() {
        return item;
    }
}
