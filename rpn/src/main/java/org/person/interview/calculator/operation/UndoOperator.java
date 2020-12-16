package org.person.interview.calculator.operation;

import org.person.interview.calculator.CalculatingContext;
import org.person.interview.calculator.ExpressionItem;

import java.util.List;

public class UndoOperator extends AbstractOperationItem {

    public UndoOperator(ExpressionItem item){
        super(item);
    }

    @Override
    public void execute(CalculatingContext context) {
        if(context.getOperationLogCount() < 1){
            return;
        }

        OperationLog operationLog = context.popOperationLog();
        IOperationItem operationItem = operationLog.getOperation();
        operationItem.undo(context, operationLog);
    }

    @Override
    protected Operand doExecute(List<Operand> operands) {
        return null;
    }

    @Override
    public int getOperandCount() {
        return 0;
    }
}
