package org.person.interview.calculator.exception;

import lombok.Getter;

@Getter
public class UnsupportedOperatorException extends RuntimeException {
    int actualAugmentCount;
    int expectAugmentCount;

    public UnsupportedOperatorException(String operator){
        super("Unsupported operator:" + operator);
    }
}
