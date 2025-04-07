package org.example;

public class FeedbackHandler extends Handler{

    @Override
    public void process(Message message) {
        if (message.messageType == MessageType.FEEDBACK) {
            System.out.println("General feedback message: '" + message.message + "' has been analyzed and responded to.");
        }
        else {
            System.out.println("Message can't be processed by feedback handler. Sending to next handler.");
            super.process(message);
        }
    }
}
