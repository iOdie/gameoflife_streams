package org.example.exceptions;

public class InvalidGameTypeException extends Exception{

    public InvalidGameTypeException (String input) {
        super(input);
    }
}
