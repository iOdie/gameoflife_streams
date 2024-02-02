package org.example;

import org.example.exceptions.InvalidGameTypeException;

import static org.example.Rules.*;
import static org.example.Rules.checkIfCellHasTwoOrThreeNeighbors;

public class Spiel {


    GameOfLifeBoard board;
    private int[][] preset;

    public void execute (int gamePreset) throws InvalidGameTypeException {
        setPreset(gamePreset); // add test if input is integer
        board = new GameOfLifeBoard(preset);
        doIterations(10);
    }

    private void setPreset (int gamePreset) throws InvalidGameTypeException {
        if (gamePreset <= 2) {
            switch (gamePreset) {
                case 1:
                    preset = new int[][] {{0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,1,0,0,0},
                                          {0,0,0,1,0,0,0},
                                          {0,0,0,1,0,0,0},
                                          {0,0,0,0,0,0,0}};
                    break;
                case 2:
                    preset = new int[][] {{0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,1,1,1,0,0},
                                          {0,0,0,0,0,0,0},
                                          {0,0,0,0,0,0,0}};
            }
        } else {
            throw new InvalidGameTypeException("Not a valid game type. Choose 1-4");
        }
    }

    public void doIterations (int count) {
        for(int i = 0; i < count; i++) {
            setNextIteration();
        }
    }
    private void setNextIteration () {
        int[][] currentIteration = board.getBoard();
        int[][] nextIterationGameBoard = new int[currentIteration.length][currentIteration[0].length];

        for (int row = 0; row < currentIteration.length; row++) {
            for(int col = 0; col < currentIteration[row].length; col++) {
                if (checkIfCellWillBeAlive(countNeighborsOfCell(row, col), currentIteration[row][col])) {
                    nextIterationGameBoard[row][col] = 1;
                }
            }
            board.setBoard(nextIterationGameBoard);
        }
    }

    public boolean checkIfCellWillBeAlive (int neighborCount, int cellState) {

        return     !checkIfCellIsOverpopulated(neighborCount, cellState)
                && checkIfCellIsReproducing(neighborCount, cellState)
                && !checkIfCellIsUnderpopulated(neighborCount, cellState)
                && checkIfCellHasTwoOrThreeNeighbors(neighborCount, cellState);
    }

    private int countNeighborsOfCell (int row, int col) {
        int sum = 0;
        return sum + (countNeighborsOfCellAbove(row, col) + countNeighborsOfCellEven(row, col) + countNeighborsOfCellBelow(row, col));
    }

    public int countNeighborsOfCellAbove(int row, int col) {
        int sum = 0;

        try {
            if(preset[row - 1][col - 1] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            if(preset[row - 1][col] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            if(preset[row - 1][col + 1] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }
        return sum;
    }

    public int countNeighborsOfCellEven(int row, int col) {
        int sum = 0;

        try {
            if(preset[row][col - 1] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            if(preset[row][col + 1] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }
        return sum;
    }

    public int countNeighborsOfCellBelow(int row, int col) {
        int sum = 0;

        try {
            if(preset[row + 1][col - 1] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            if(preset[row + 1][col] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }

        try {
            if(preset[row + 1][col + 1] == 1) {
                sum++;
            }
        } catch (NullPointerException e) {
            // do nothing
        }
        return sum;
    }
}
