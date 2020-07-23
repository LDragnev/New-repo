package com.lyuben.classes;

import java.util.Arrays;
import java.util.Scanner;

class Reader {
    private final Scanner scanner;

    Reader(){
        this.scanner = new Scanner(System.in);
    }

    public int[] readInput(){
        String input = this.scanner.nextLine();
        return Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
    }
    public int[][] readMatrix(int[] size){
        int width = size[0];
        int height = size[1];
        int[][] matrix = new int[height][width];
        for (int row = 0; row < height; row++) {
            String line = scanner.nextLine();
             int[] matrixLine = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
             if (matrixLine.length > matrix[row].length){
                 throw new IllegalArgumentException("Number of input elements must be equal to matrix width!");
             }
             matrix[row] = matrixLine;
        }
        return matrix;
    }


}
