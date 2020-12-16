package org.person.interview.calculator.operation;

import org.person.interview.calculator.ExpressionItem;

import java.math.BigDecimal;
import java.util.List;

public class SqrtOperator extends AbstractOperationItem {

    public SqrtOperator(ExpressionItem item){
        super(item);
    }

    @Override
    protected Operand doExecute(List<Operand> operands) {

        Operand op1 = operands.get(0);

        BigDecimal b1 = new BigDecimal(op1.getExpressionItem().getValue());

        Operand result = operationItemFactory.createOperand(BigDecimal.valueOf(Math.sqrt(b1.doubleValue())));
        return result;
    }

    @Override
    public int getOperandCount() {
        return 1;
    }
}
