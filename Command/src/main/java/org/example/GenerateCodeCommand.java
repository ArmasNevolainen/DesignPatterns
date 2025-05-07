package org.example;



public class GenerateCodeCommand implements Command {
    private final PixelEditor editor;

    public GenerateCodeCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.generateCode();
    }
}
