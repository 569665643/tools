package org.person.interview.calculator.factory;

import org.person.interview.calculator.config.Configuration;
import org.person.interview.calculator.config.IConfiguration;
import org.person.interview.calculator.operation.*;
import org.person.interview.calculator.ExpressionItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class OperationItemFactory implements IOperationItemFactory {
    @Autowired
    private IConfiguration configuration;

    @Override
    public Operand createOperand(String value) {

        Operand operand = new Operand(new ExpressionItem(value, -1));
        return operand;
    }

    @Override
    public Operand createOperand(BigDecimal value) {
        return this.createOperand(value.toString());
    }

    @Override
    public Operand createOperand(ExpressionItem item) {
        Operand operand = new Operand(item);
        return operand;
    }

    @Override
    public IOperationItem createOperator(ExpressionItem item) {
       try{
           String operatorClass = this.configuration.getOperatorClass(item.getValue());
           Class<?> classClass = Class.forName(operatorClass);
           return (IOperationItem) classClass.getDeclaredConstructor(ExpressionItem.class).newInstance(item);

       }catch(Exception ex){
           return new InvalidOperationItem(item);
       }
    }
}
