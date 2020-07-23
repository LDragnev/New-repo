package com.lyuben.classes;

class GreenColorCounter {
    private int x1;
    private int y1;
    private int greenColorCounts;

    GreenColorCounter(int[] coordinates) {
        this.x1 = coordinates[0];
        this.y1 = coordinates[1];
    }

    public void count(Grid grid){
        if (grid.isGreenCell(this.y1,this.x1)){
            this.greenColorCounts+=1;
        }
    }

    public int getGreenColorCounts() {
        return greenColorCounts;
    }
}
