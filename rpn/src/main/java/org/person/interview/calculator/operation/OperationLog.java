package org.person.interview.calculator.operation;

import java.util.List;

public class OperationLog {
    private IOperationItem operation;
    private List<Operand> operands;
    private Operand result;

    public OperationLog(IOperationItem operation, List<Operand> operands, Operand result){
        this.operation = operation;
        this.operands = operands;
        this.result = result;
    }

    public Operand getResult() {
        return result;
    }

    public IOperationItem getOperation() {
        return operation;
    }

    public List<Operand> getOperands() {
        return operands;
    }
}
