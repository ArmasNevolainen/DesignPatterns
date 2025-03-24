public class TextFieldB extends TextField{


    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int padding = 5;

        System.out.println("++++++++++" + "+".repeat(text.length()) + "++");
        System.out.println("+" + " ".repeat(padding) + text + " ".repeat(padding) + "+");
        System.out.println("++++++++++" + "+".repeat(text.length()) + "++");
    }
}
