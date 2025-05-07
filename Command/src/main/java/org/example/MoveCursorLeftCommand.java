package org.example;



public class MoveCursorLeftCommand implements Command {
    private final PixelEditor editor;

    public MoveCursorLeftCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorLeft();
    }
}
