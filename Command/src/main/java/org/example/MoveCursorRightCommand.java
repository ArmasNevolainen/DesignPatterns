package org.example;



public class MoveCursorRightCommand implements Command {
    private final PixelEditor editor;

    public MoveCursorRightCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorRight();
    }
}
