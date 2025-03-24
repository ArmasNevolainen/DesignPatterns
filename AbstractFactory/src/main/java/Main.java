import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UIFactory factory = null;

        System.out.println("Choose UI style (1 for Style A, 2 for Style B):");
        int styleChoice = scanner.nextInt();
        scanner.nextLine();

        if (styleChoice == 1) {
            factory = new AFactory();
            System.out.println("Style A selected");
        } else {
            factory = new BFactory();
            System.out.println("Style B selected");
        }

        Button button = factory.createButton("Click Me");
        Checkbox checkbox = factory.createCheckbox("Check it");
        TextField textField = factory.createTextfield("Enter text here");

        button.display();

        checkbox.display();

        textField.display();

        button.setText("Don't click!");
        button.display();
        checkbox.setText("Don't check it!");
        checkbox.display();
        textField.setText("Do not enter text here!");
        textField.display();
    }
}