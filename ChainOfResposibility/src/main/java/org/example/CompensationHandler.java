package org.example;

import static org.example.MessageType.COMPENSATION;

public class CompensationHandler extends Handler {

    @Override
    public void process(Message message) {
        if (message.messageType == COMPENSATION) {
            System.out.println("Compensation claim: " + message.message + "has been reviewed");
        }
        else {
            System.out.println("Message can't be reviewed by compensation handler. Sending to next handler");
            super.process(message);
        }
    }
}
