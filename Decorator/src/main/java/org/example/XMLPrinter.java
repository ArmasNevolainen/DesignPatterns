package org.example;

public class XMLPrinter extends PrinterDecorator {
    public XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        System.out.println("<message> " + message + "</message>");
    }
}
