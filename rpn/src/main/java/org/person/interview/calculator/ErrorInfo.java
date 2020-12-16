package org.person.interview.calculator;


public class ErrorInfo {
    ExpressionItem item;
    String msg;

    public ErrorInfo(ExpressionItem item, String msg){
        this.item = item;
        this.msg = msg;
    }

    public ExpressionItem getItem(){
        return this.item;
    }

    public String getMsg(){
        return this.msg;
    }
}
