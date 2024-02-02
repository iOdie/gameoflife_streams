package org.example;

public class GameOfLifeBoard {

    private int[][] board;

    public GameOfLifeBoard (int[][] board) {
        setBoard(board);
    }


    public void printBoard () {
        for (int[] rows : board) {
            for (int cells : rows) {
                System.out.print(cells);
            }
            System.out.println();
        }
    }

    public int[][] getBoard () {
        return board;
    }

    public void setBoard (int[][] board) {
        this.board = board;
    }
}
