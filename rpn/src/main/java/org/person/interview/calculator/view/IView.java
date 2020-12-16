package org.person.interview.calculator.view;

import org.person.interview.calculator.CalculateState;

public interface IView {
    void show(CalculateState state);
    void start();
}
