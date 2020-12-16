package org.person.interview.calculator.exception;

public class DivideZeroException extends RuntimeException {
   public DivideZeroException(){
        super("Operand is zero");
    }
}
