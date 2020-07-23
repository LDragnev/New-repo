package com.lyuben.classes;

import java.util.Arrays;

class Grid {
    private int[][] mainMatrix;
    private int[][] shadowMatrix;


    Grid(int[][] mainMatrix) {
        this.mainMatrix = mainMatrix;
        //second matrix to keep the result of next generation
        this.shadowMatrix = copyMatrix(mainMatrix);
    }

    private int[][] copyMatrix(int[][] matrix){
        int[][] newMatrix = new int[matrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            newMatrix[row] = Arrays.copyOf(matrix[row],matrix[row].length);
        }
        return newMatrix;
    }

    public void nextGeneration(){
        for (int row = 0; row < this.mainMatrix.length; row++) {
            for (int col = 0; col < this.mainMatrix[row].length; col++) {
                int greenNeighbours = checkGreenNeighbours(this.mainMatrix,row, col);
                if (isGreenCell(row, col)) {
                    if (!remainGreen(greenNeighbours)) {
                        this.shadowMatrix[row][col] = 0;
                    }
                } else {
                    if (!remainRed(greenNeighbours)) {
                        this.shadowMatrix[row][col] = 1;
                    }
                }
            }
        }
        //copying new generation from second matrix to the main matrix
        this.mainMatrix = this.copyMatrix(shadowMatrix);

    }
    //checks if a cell has to remain red next generation turn
    private boolean remainRed(int greenNeighbours) {
        return greenNeighbours != 3 && greenNeighbours != 6;
    }
    //checks if a cell has to remain green next generation turn
    private boolean remainGreen(int greenNeighbours) {
        return greenNeighbours == 2 || greenNeighbours == 3 || greenNeighbours == 6;
    }
    //checks if a cell color is green
    public boolean isGreenCell(int row, int col) {
        return this.mainMatrix[row][col] == 1;
    }
    //checks the color of all neighbors of a cell
    private static int checkGreenNeighbours(int[][] grid, int row, int col) {
        int sum = 0;
        //check top

        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            sum += 1;
        }
        //check down
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            sum += 1;
        }
        //check left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            sum += 1;
        }
        //check right
        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            sum += 1;
        }
        //check top-left
        if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 1) {
            sum += 1;
        }
        //check top-right
        if (row - 1 >= 0 && col + 1 < grid[row].length && grid[row - 1][col + 1] == 1) {
            sum += 1;
        }
        //check bottom-left
        if (row + 1 < grid.length && col - 1 >= 0 && grid[row + 1][col - 1] == 1) {
            sum += 1;
        }
        //check bottom-right
        if (row + 1 < grid.length && col + 1 < grid[row].length && grid[row + 1][col + 1] == 1) {
            sum += 1;
        }
        return sum;
    }
}
