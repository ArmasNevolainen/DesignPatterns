package org.example;


public class TogglePixelCommand implements Command {
    private final PixelEditor editor;

    public TogglePixelCommand(PixelEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.togglePixel();
    }
}
