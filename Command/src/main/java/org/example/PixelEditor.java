package org.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PixelEditor {
    private static final int GRID_SIZE = 8;
    private final int[][] grid = new int[GRID_SIZE][GRID_SIZE];
    private final IntegerProperty cursorX = new SimpleIntegerProperty(0);
    private final IntegerProperty cursorY = new SimpleIntegerProperty(0);
    private final SimpleObjectProperty<int[][]> gridProperty = new SimpleObjectProperty<>(grid);

    public PixelEditor() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void moveCursorUp() {
        if (cursorY.get() > 0) {
            cursorY.set(cursorY.get() - 1);
        }
    }

    public void moveCursorDown() {
        if (cursorY.get() < GRID_SIZE - 1) {
            cursorY.set(cursorY.get() + 1);
        }
    }

    public void moveCursorLeft() {
        if (cursorX.get() > 0) {
            cursorX.set(cursorX.get() - 1);
        }
    }

    public void moveCursorRight() {
        if (cursorX.get() < GRID_SIZE - 1) {
            cursorX.set(cursorX.get() + 1);
        }
    }

    public void togglePixel() {
        int x = cursorX.get();
        int y = cursorY.get();
        grid[y][x] = grid[y][x] == 0 ? 1 : 0;
        gridProperty.set(grid.clone());
    }

    public String generateCode() {
        StringBuilder code = new StringBuilder("int[][] pixelArt = {\n");
        for (int i = 0; i < GRID_SIZE; i++) {
            code.append("    {");
            for (int j = 0; j < GRID_SIZE; j++) {
                code.append(grid[i][j]);
                if (j < GRID_SIZE - 1) {
                    code.append(", ");
                }
            }
            code.append("}");
            if (i < GRID_SIZE - 1) {
                code.append(",");
            }
            code.append("\n");
        }
        code.append("};");
        String result = code.toString();
        System.out.println(result);
        return result;
    }

    public IntegerProperty cursorXProperty() {
        return cursorX;
    }

    public IntegerProperty cursorYProperty() {
        return cursorY;
    }

    public SimpleObjectProperty<int[][]> gridProperty() {
        return gridProperty;
    }

    public int getCursorX() {
        return cursorX.get();
    }

    public int getCursorY() {
        return cursorY.get();
    }

    public int[][] getGrid() {
        return grid;
    }
}
