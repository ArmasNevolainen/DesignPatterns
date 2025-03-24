public class CheckboxA extends Checkbox{

    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        int padding = 3;
        System.out.println("╭───╮" + "─".repeat(padding) + "─".repeat(text.length()) + "─".repeat(padding));
        System.out.println("│ " +  "  │" + " ".repeat(padding) + text + " ".repeat(padding));
        System.out.println("╰───╯" + "─".repeat(padding) + "─".repeat(text.length()) + "─".repeat(padding));
    }

    }

