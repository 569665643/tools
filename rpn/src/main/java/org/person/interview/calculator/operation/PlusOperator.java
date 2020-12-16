package org.person.interview.calculator.operation;

import org.person.interview.calculator.ExpressionItem;

import java.math.BigDecimal;
import java.util.List;

public class PlusOperator extends AbstractOperationItem {

    public PlusOperator(ExpressionItem item){
        super(item);
    }

    @Override
    protected Operand doExecute(List<Operand> operands) {

        Operand op1 = operands.get(0);
        Operand op2 = operands.get(1);

        BigDecimal b1 = new BigDecimal(op1.getExpressionItem().getValue());
        BigDecimal b2 = new BigDecimal(op2.getExpressionItem().getValue());

        Operand result = operationItemFactory.createOperand(b1.add(b2));
        return result;
    }

    @Override
    public int getOperandCount() {
        return 2;
    }
}
