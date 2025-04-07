package org.example;

public class DevelopmentHandler extends Handler {
    @Override
    public void process(Message message) {
        if (message.messageType == MessageType.DEVELOPMENT) {
            System.out.println("Development message: " + message.message + "has been logged and prioritized.");
        }
        else {
            System.out.println("Message can't be processed by development handler. Sending to next handler");
            super.process(message);
        }
    }
}
