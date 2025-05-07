package org.example;



public class MoveCursorDownCommand implements Command {
    private final PixelEditor editor;

    public MoveCursorDownCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorDown();
    }
}
