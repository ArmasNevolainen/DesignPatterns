package org.example;



public class Main {
    public static void main(String[] args) {

        Handler primaryHandler;
        Handler compensationHandler = new CompensationHandler();
        Handler contactHandler = new ContactHandler();
        Handler developmentHandler = new DevelopmentHandler();
        Handler feedbackHandler = new FeedbackHandler();
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(feedbackHandler);
        primaryHandler = compensationHandler;

        Message feedbackMessage = new Message("Thank you for your excellent work", MessageType.FEEDBACK, "joe@gmail.com" );
        primaryHandler.process(feedbackMessage);
    }
}