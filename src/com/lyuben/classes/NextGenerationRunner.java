package com.lyuben.classes;

public class NextGenerationRunner {
    private Reader reader;
    private Grid grid;
    private int[] inputSize;
    private int[][] inputMatrix;
    private int[] inputCoordinates;
    private TurnSwapper turnSwapper;

    public NextGenerationRunner() {
    }

    public int run(){
        this.reader = new Reader();
        this.setInputSize();
        this.setInputMatrix();
        this.setInputCoordinates();
        this.setGrid();
        this.setTurnSwapper();
        return this.turnSwapper.swapTurns();
    }
    private void setInputSize(){
        this.inputSize = this.reader.readInput();
    }
    private void setInputMatrix(){
        this.inputMatrix = this.reader.readMatrix(this.inputSize);
    }
    private void setInputCoordinates(){
        this.inputCoordinates = this.reader.readInput();
    }
    private void setGrid(){
        this.grid = new Grid(this.inputMatrix);
    }
    private void setTurnSwapper(){
        this.turnSwapper = new TurnSwapper(this.grid,this.inputCoordinates);
    }
}
