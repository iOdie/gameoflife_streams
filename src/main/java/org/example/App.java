package org.example;

import org.example.exceptions.InvalidGameTypeException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InvalidGameTypeException {
        Spiel gameOfLife = new Spiel();
        gameOfLife.execute(1);
    }

}
