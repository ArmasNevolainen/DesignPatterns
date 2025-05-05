package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    private static final String[] USERNAMES = {"Client 1", "Client 2", "Client 3"};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ChatClient mediator = new ChatClientImplementation();

        for (String username : USERNAMES) {
            ChatClientController controller = new ChatClientController(username, mediator);
            Stage stage = new Stage();
            controller.show(stage);
        }
    }
}
