package org.example;

import javafx.application.Application;
import javafx.stage.Stage;



public class PixelEditorApplication extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PixelEditor editor = new PixelEditor();

        PixelEditorUI ui = new PixelEditorUI(editor);

        ui.start(primaryStage);
    }
}