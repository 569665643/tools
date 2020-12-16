package org.person.interview.calculator;

import java.util.Stack;

public class CalculateState {
    private ErrorInfo errorInfo;
    private Stack<String> operandStack = new Stack<>();

    public Stack<String> getOperandStack() {
        return operandStack;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public void setOperandStack(Stack<String> operandStack) {
        this.operandStack = operandStack;
    }
}
