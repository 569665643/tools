package org.person.interview.calculator.config;

public interface IConfiguration {
    int getPrecision();
    boolean isSupportedOperator(String operator);

    String getOperatorClass(String operator);
}
