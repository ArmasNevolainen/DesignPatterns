package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Game extends Application {
    private Map currentMap;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        HBox controlPanel = new HBox(10);
        Button cityMapBtn = new Button("City Map");
        Button wildernessMapBtn = new Button("Wilderness Map");
        Label infoLabel = new Label("Select a map type to generate");

        controlPanel.getChildren().addAll(cityMapBtn, wildernessMapBtn, infoLabel);
        root.setTop(controlPanel);

        cityMapBtn.setOnAction(e -> {
            currentMap = createMap(1);
            Canvas mapCanvas = MapRenderer.renderMap(currentMap);
            root.setCenter(mapCanvas);
        });

        wildernessMapBtn.setOnAction(e -> {
            currentMap = createMap(2);
            Canvas mapCanvas = MapRenderer.renderMap(currentMap);
            root.setCenter(mapCanvas);
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("RPG Map Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Map createMap(int type) {
        int rows = 16;
        int columns = 24;

        if (type == 1) {
            return new CityMap(rows, columns);
        } else {
            return new WildernessMap(rows, columns);
        }
    }
}
