package org.example.enums;

public enum Cell {
    ALIVE(1), DEAD(0);

    private int value;

    private Cell(int value) {
        this.value = value;
    }
}
