public class BFactory implements UIFactory{
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }

    @Override
    public TextField createTextfield(String text) {
        return new TextFieldB(text);
    }
}
