package org.person.interview.calculator.config;

import org.person.interview.calculator.exception.UnsupportedOperatorException;

import java.util.HashMap;

public class Configuration implements IConfiguration{
    private static HashMap<String, String>  supportedOperators = null;

    static{
        supportedOperators = new HashMap<String, String>();

        supportedOperators.put("+", "org.person.interview.calculator.operation.PlusOperator");
        supportedOperators.put("-", "org.person.interview.calculator.operation.SubtractOperator");
        supportedOperators.put("*", "org.person.interview.calculator.operation.MultiplyOperator");
        supportedOperators.put("/", "org.person.interview.calculator.operation.DivideOperator");
        supportedOperators.put("sqrt", "org.person.interview.calculator.operation.SqrtOperator");
        supportedOperators.put("undo", "org.person.interview.calculator.operation.UndoOperator");
        supportedOperators.put("clear", "org.person.interview.calculator.operation.ClearOperator");
    }

    @Override
    public int getPrecision() {
        return 10;
    }

    @Override
    public boolean isSupportedOperator(String operator) {
        return supportedOperators.containsKey(operator);
    }

    @Override
    public String getOperatorClass(String operator) {
        String operatorClass = supportedOperators.getOrDefault(operator, null);
        if(operatorClass == null){
            throw new UnsupportedOperatorException(operator);
        }

        return operatorClass;
    }
}
