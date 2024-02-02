package org.example;

public class Rules {

    public static boolean checkIfCellIsUnderpopulated (int neighborCount, int cellState) {
        return (neighborCount < 2 && cellState == 1);
    }

    public static boolean checkIfCellHasTwoOrThreeNeighbors (int neighborCount, int cellState) {
        return ((neighborCount == 2 || neighborCount == 3) && cellState == 1);
    }

    public static boolean checkIfCellIsOverpopulated (int neighborCount, int cellState) {
        return (neighborCount > 3 && cellState == 1);
    }

    public static boolean checkIfCellIsReproducing (int neighborCount, int cellState) {
        return (neighborCount == 3 && cellState == 0);
    }
}
