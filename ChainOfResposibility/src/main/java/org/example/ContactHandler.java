package org.example;

public class ContactHandler extends Handler {
    @Override
    public void process(Message message) {
        if (message.messageType == MessageType.CONTACT) {
            System.out.println("Contact message: " + message.message + "has been forwarded.");
        }
        else {
            System.out.println("Message can't be processed by contact handler. Sending to next handler");
            super.process(message);
        }
    }

}
