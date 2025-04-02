package org.example;

public class EncryptedPrinter extends PrinterDecorator{

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(encrypt(message));
    }
    private String encrypt (String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int position = c - 'a' + 1;
                result.append(position).append(" ");
            } else {
                result.append(c).append(" ");
            }
        }


        return result.toString();
    }
}
