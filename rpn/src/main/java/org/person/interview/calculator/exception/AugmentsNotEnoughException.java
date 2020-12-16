package org.person.interview.calculator.exception;

import lombok.Getter;

@Getter
public class AugmentsNotEnoughException extends RuntimeException {
    int actualAugmentCount;
    int expectAugmentCount;

    public AugmentsNotEnoughException(int actualAugmentCount, int expectAugmentCount){
        super("Insufficient parameters");
        this.actualAugmentCount = actualAugmentCount;
        this.expectAugmentCount = expectAugmentCount;

    }
}
