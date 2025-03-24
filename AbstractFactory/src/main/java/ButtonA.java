public class ButtonA extends Button{

    public ButtonA(String text){
        super(text);
    }
    public void display(){
        int padding = 2;

        System.out.println("╭──" + "─".repeat(text.length()) + "──╮");
        System.out.println("│" + " ".repeat(padding) + text + " ".repeat(padding) + "│");
        System.out.println("╰──" + "─".repeat(text.length()) + "──╯");
    }
}
