package org.person.interview.calculator.operation;

import org.person.interview.calculator.CalculatingContext;
import org.person.interview.calculator.ExpressionItem;

import java.util.ArrayList;
import java.util.List;

public class ClearOperator extends AbstractOperationItem {

    public ClearOperator(ExpressionItem item){
        super(item);
    }

    @Override
    public void execute(CalculatingContext context) {
        List<Operand> operands = new ArrayList<>();
        while(context.getOperandCount() > 0) {
            operands.add(0, context.popOperand());
        }

        OperationLog log = operationLogFactory.create(this, operands, null);
        context.pushOperationLog(log);
    }

    @Override
    protected Operand doExecute(List<Operand> operands) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getOperandCount() {
        throw new UnsupportedOperationException();
    }
}
