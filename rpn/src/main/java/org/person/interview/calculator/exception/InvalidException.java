package org.person.interview.calculator.exception;

public class InvalidException extends RuntimeException{
    public InvalidException(){
        super("expression is invalid.");
    }
}
