package org.person.interview.calculator;

import org.person.interview.calculator.operation.Operand;
import org.person.interview.calculator.operation.OperationLog;

import java.util.List;
import java.util.Stack;
public class CalculatingContext {
    private Stack<Operand> operandStack = new Stack<>();
    private Stack<OperationLog> logStack = new Stack<OperationLog>();

    public Stack<String> getOperandStack(){
        Stack<String> stateStack = new Stack<>();
        operandStack.stream().forEach( operand -> stateStack.push(operand.getExpressionItem().getValue()));
        return stateStack;
    }

    public int getOperandCount(){
        return this.operandStack.size();
    }

    public int getOperationLogCount(){
        return this.logStack.size();
    }

    public Operand popOperand(){
        return this.operandStack.pop();
    }

    public void pushOperand(Operand item){
        this.operandStack.push(item);
    }

    public void pushOperands(List<Operand> operands){
        operands.stream().forEach(op -> this.operandStack.push(op));
    }

    public OperationLog popOperationLog(){
        return this.logStack.pop();
    }

    public void pushOperationLog(OperationLog item){
        this.logStack.push(item);
    }
}
