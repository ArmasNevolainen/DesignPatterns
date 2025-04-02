package org.example;

public class PrinterDecorator implements Printer{

    private Printer decoratedPrinter;

    public PrinterDecorator(Printer printer) {
        this.decoratedPrinter = printer;
    }

    @Override
    public void print(String message) {
        decoratedPrinter.print(message);
    }


}
