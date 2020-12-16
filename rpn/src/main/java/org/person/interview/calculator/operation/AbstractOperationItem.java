package org.person.interview.calculator.operation;

import org.person.interview.calculator.CalculatingContext;
import org.person.interview.calculator.ExpressionItem;
import org.person.interview.calculator.ServiceLocator;
import org.person.interview.calculator.exception.AugmentsNotEnoughException;
import org.person.interview.calculator.factory.IOperationItemFactory;
import org.person.interview.calculator.factory.IOperationLogFactory;
import org.person.interview.calculator.factory.OperationLogFactory;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractOperationItem implements IOperationItem {
    protected ExpressionItem expressionItem;

    protected IOperationItemFactory operationItemFactory;
    protected IOperationLogFactory operationLogFactory = new OperationLogFactory();

    protected AbstractOperationItem(ExpressionItem item){
        operationItemFactory = (IOperationItemFactory) ServiceLocator.getApplicationContext().getBean("operationItemFactory");
        operationLogFactory = (IOperationLogFactory) ServiceLocator.getApplicationContext().getBean("operationLogFactory");
        this.expressionItem = item;
    }

    @Override
    public void execute(CalculatingContext context) {
        if (context.getOperandCount() < this.getOperandCount()) {
            throw new AugmentsNotEnoughException(context.getOperandCount(), this.getOperandCount());
        }

        List<Operand> operands = new ArrayList<>();
        for(int i = 0; i < this.getOperandCount() && context.getOperandCount() > 0; ++i){
            operands.add(0, context.popOperand());
        }
        Operand result = null;
        try {
            result = this.doExecute(operands);
            if (result != null) {
                context.pushOperand(result);
            }
        }catch(Exception ex){
            context.pushOperands(operands);
            throw ex;
        }

        OperationLog log = operationLogFactory.create(this, operands, result);
        context.pushOperationLog(log);

    }

    @Override
    public void undo(CalculatingContext context, OperationLog log) {
        if(log.getResult() != null) {
            context.popOperand();
        }
        List<Operand> operands = log.getOperands();
        context.pushOperands(operands);
    }

    protected abstract Operand doExecute(List<Operand> operands);

    @Override
    public ExpressionItem getExpressionItem() {
        return this.expressionItem;
    }
}
