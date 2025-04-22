package org.example;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize;
    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }
    @Override
    public void visit(Directory directory) {

    }
    public int getTotalSize() {
        return totalSize;
    }
}
