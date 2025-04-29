package org.example;

import java.util.Random;

public abstract class Map {
    protected Tile [][] tiles;
    protected int rows;
    protected int columns;
    protected final Random random = new Random();

    public Map (int rows,int columns){
        this.rows = rows;
        this.columns = columns;
        this.tiles = new Tile[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                tiles[i][j] = createTile();
            }
        }
    }

    protected abstract Tile createTile();
    public void display() {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
