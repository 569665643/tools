package org.person.interview.calculator;

import org.person.interview.calculator.view.IView;
import org.springframework.beans.factory.annotation.Autowired;


public class Controller{
    private CalculatingContext calculationContext = new CalculatingContext();

    @Autowired
    private IView view;

    @Autowired
    private ICalculator calculator;

    public void input(Expression expression) {
        this.view.show( this.calculator.calculate(expression));
    }


    public void start() {
        this.view.start();
    }

    public void close() {
        System.exit(0);
    }
}
