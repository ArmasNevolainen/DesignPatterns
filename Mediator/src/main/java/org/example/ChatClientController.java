package org.example;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatClientController {
    private final String username;
    private final ChatClient mediator;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientBox;

    public ChatClientController(String username, ChatClient mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void show(Stage stage) {
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        messageField = new TextField();
        messageField.setPromptText("Type your message...");

        recipientBox = new ComboBox<>();
        recipientBox.setPromptText("Select recipient");
        updateRecipients();

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        HBox inputBox = new HBox(5, recipientBox, messageField, sendButton);
        VBox root = new VBox(10, chatArea, inputBox);
        root.setPrefSize(400, 300);

        stage.setTitle("Chat - " + username);
        stage.setScene(new Scene(root));
        stage.show();

        // Update recipient list when window gains focus
        stage.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) updateRecipients();
        });
    }

    private void updateRecipients() {
        String[] users = mediator.getClientUsernames();
        recipientBox.getItems().setAll(users);
        recipientBox.getItems().remove(username); // can't send to self
    }

    private void sendMessage() {
        String to = recipientBox.getValue();
        String msg = messageField.getText().trim();
        if (to == null || msg.isEmpty()) return;
        mediator.sendMessage(username, to, msg);
        appendMessage("To " + to + ": " + msg);
        messageField.clear();
    }

    public void receiveMessage(String from, String message) {
        Platform.runLater(() -> appendMessage("From " + from + ": " + message));
    }

    private void appendMessage(String msg) {
        chatArea.appendText(msg + "\n");
    }
}
