package org.person.interview.calculator;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<ExpressionItem>  Items = new ArrayList<>();

    public void add(ExpressionItem item){
        this.Items.add(item);
    }

    public List<ExpressionItem> getItems(){
        return this.Items;
    }

    public static Expression createFromString(String strExpression){
        Expression expression = new Expression();

        if(StringUtils.isEmpty(strExpression)){
            return expression;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strExpression.length(); ++ i){
            String chStr = strExpression.substring(i, i + 1);
            if(StringUtils.isBlank(chStr)){
                if(sb.length() > 0){
                    ExpressionItem expressionItem = new ExpressionItem(sb.toString(), i - sb.length() + 1);
                    expression.add(expressionItem);
                    sb.setLength(0);
                }
            }else{
                sb.append(chStr);
            }
        }

        if(sb.length() > 0){
            ExpressionItem expressionItem = new ExpressionItem(sb.toString(), strExpression.length() - sb.length());
            expression.add(expressionItem);
        }

        return expression;
    }
}
