package org.person.interview.calculator;

import org.apache.commons.lang.math.NumberUtils;
import org.person.interview.calculator.config.Configuration;
import org.person.interview.calculator.config.IConfiguration;
import org.person.interview.calculator.factory.IOperationItemFactory;
import org.person.interview.calculator.factory.OperationItemFactory;
import org.person.interview.calculator.operation.IOperationItem;
import org.person.interview.calculator.operation.InvalidOperationItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser implements IExpressionParser{
    @Autowired
    private IConfiguration config;

    @Autowired
    private IOperationItemFactory operationItemFactory;

    @Override
    public List<IOperationItem> getExpression(Expression expression) {
        List<IOperationItem> operationItems = new ArrayList<>();
        for(ExpressionItem item : expression.getItems()){
            if(NumberUtils.isNumber(item.getValue())){
                operationItems.add(this.operationItemFactory.createOperand(item));
                continue;
            }

            if(config.isSupportedOperator(item.getValue())){
                operationItems.add(this.operationItemFactory.createOperator(item));
                continue;
            }

            InvalidOperationItem invalidOperationItem = new InvalidOperationItem(item);
            operationItems.add(invalidOperationItem);
        }

        return operationItems;
    }
}
