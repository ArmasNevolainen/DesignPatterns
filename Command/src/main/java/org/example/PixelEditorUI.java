package org.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelEditorUI {
    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE = 8;

    private final PixelEditor editor;
    private final Command moveCursorUpCommand;
    private final Command moveCursorDownCommand;
    private final Command moveCursorLeftCommand;
    private final Command moveCursorRightCommand;
    private final Command togglePixelCommand;
    private final Command generateCodeCommand;

    private final Rectangle[][] cells = new Rectangle[GRID_SIZE][GRID_SIZE];
    private final Rectangle cursor = new Rectangle(CELL_SIZE - 4, CELL_SIZE - 4);
    private final GridPane gridPane = new GridPane();

    public PixelEditorUI(PixelEditor editor) {
        this.editor = editor;

        this.moveCursorUpCommand = new MoveCursorUpCommand(editor);
        this.moveCursorDownCommand = new MoveCursorDownCommand(editor);
        this.moveCursorLeftCommand = new MoveCursorLeftCommand(editor);
        this.moveCursorRightCommand = new MoveCursorRightCommand(editor);
        this.togglePixelCommand = new TogglePixelCommand(editor);
        this.generateCodeCommand = new GenerateCodeCommand(editor);
    }

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        createGridPane();

        Button generateCodeButton = new Button("Create Code");
        generateCodeButton.setOnAction(e -> generateCodeCommand.execute());

        root.setCenter(gridPane);
        root.setBottom(generateCodeButton);
        BorderPane.setMargin(generateCodeButton, new Insets(10));

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    moveCursorUpCommand.execute();
                    break;
                case DOWN:
                    moveCursorDownCommand.execute();
                    break;
                case LEFT:
                    moveCursorLeftCommand.execute();
                    break;
                case RIGHT:
                    moveCursorRightCommand.execute();
                    break;
                case SPACE:
                    togglePixelCommand.execute();
                    break;
                default:
                    break;
            }
        });

        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.getRoot().requestFocus();

        editor.cursorXProperty().addListener((obs, oldVal, newVal) -> updateCursorPosition());
        editor.cursorYProperty().addListener((obs, oldVal, newVal) -> updateCursorPosition());

        editor.gridProperty().addListener((obs, oldVal, newVal) -> updateGrid());

        updateCursorPosition();
        updateGrid();
    }

    private void createGridPane() {
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(2);
        gridPane.setVgap(2);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                StackPane cell = new StackPane();
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                cells[row][col] = rect;

                cell.getChildren().add(rect);
                gridPane.add(cell, col, row);
            }
        }

        cursor.setFill(Color.TRANSPARENT);
        cursor.setStroke(Color.RED);
        cursor.setStrokeWidth(2);

        StackPane cursorPane = new StackPane(cursor);
        gridPane.add(cursorPane, 0, 0);
    }

    private void updateCursorPosition() {
        StackPane cursorPane = (StackPane) cursor.getParent();

        gridPane.getChildren().remove(cursorPane);

        gridPane.add(cursorPane, editor.getCursorX(), editor.getCursorY());
    }

    private void updateGrid() {
        int[][] grid = editor.getGrid();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                cells[row][col].setFill(grid[row][col] == 1 ? Color.BLACK : Color.WHITE);
            }
        }
    }
}
