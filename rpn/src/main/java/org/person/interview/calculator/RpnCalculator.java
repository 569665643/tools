package org.person.interview.calculator;

import org.person.interview.calculator.operation.IOperationItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class RpnCalculator implements ICalculator {
    private CalculatingContext calculationContext = new CalculatingContext();

    @Autowired
    private IExpressionParser parser;


    @Override
    public CalculateState calculate(Expression expression) {
        CalculateState state = new CalculateState();
        List<IOperationItem> operationItemList = parser.getExpression(expression);

        if(!operationItemList.isEmpty()) {
            for (IOperationItem op : operationItemList){
                try{
                    op.execute(this.calculationContext);
                }catch (Exception ex){
                    ErrorInfo errorInfo = new ErrorInfo(op.getExpressionItem(), ex.getMessage());
                    state.setErrorInfo(errorInfo);
                    break;
                }
            }
        }

        state.setOperandStack(this.calculationContext.getOperandStack());

        return state;
    }
}
