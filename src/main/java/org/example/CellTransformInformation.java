package org.example;

public class CellTransformInformation {

    public int row;
    public int col;
    public int neighbors;
    public int alive;

    public CellTransformInformation(int row, int col, int neighbors, int alive) {
        this.row = row;
        this.col = col;
        this.neighbors = neighbors;
        this.alive = alive;
    }
}
