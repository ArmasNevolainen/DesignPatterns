package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MapRenderer {
    private static final int TILE_SIZE = 32;

    public static Canvas renderMap(Map map) {
        int width = map.columns * TILE_SIZE;
        int height = map.rows * TILE_SIZE;

        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int i = 0; i < map.rows; i++) {
            for (int j = 0; j < map.columns; j++) {
                Tile tile = map.tiles[i][j];
                Image tileImage = TileGraphicFactory.getImage(tile.getType());
                gc.drawImage(tileImage, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        return canvas;
    }
}
