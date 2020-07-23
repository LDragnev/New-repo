package com.lyuben.classes;

import com.lyuben.classes.GreenColorCounter;
import com.lyuben.classes.Grid;

class TurnSwapper {
    private Grid grid;
    private GreenColorCounter greenColorCounter;
    private int N;


    TurnSwapper(Grid grid, int[] coordinates){
        this.grid = grid;
        this.greenColorCounter = new GreenColorCounter(coordinates);
        this.N = coordinates[2];
    }
    //swaping generation turns
    public int swapTurns (){
        while (this.N >=0){
            greenColorCounter.count(grid);
            this.grid.nextGeneration();
            N-=1;
        }
        return greenColorCounter.getGreenColorCounts();
    }

}
