package org.example;

public class Message {
    public String message;
    public MessageType messageType;
    public String senderEmail;

    public Message(String message, MessageType messageType, String senderEmail) {
        this.message = message;
        this.messageType = messageType;
        this.senderEmail = senderEmail;
    }
}
