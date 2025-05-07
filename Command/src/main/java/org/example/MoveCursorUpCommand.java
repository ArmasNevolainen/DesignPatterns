package org.example;



public class MoveCursorUpCommand implements Command {
    private final PixelEditor editor;

    public MoveCursorUpCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorUp();
    }
}
