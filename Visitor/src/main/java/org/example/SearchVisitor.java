package org.example;

public class SearchVisitor implements FileSystemVisitor {
    private String keyword;
    public SearchVisitor(String keyword) {
        this.keyword = keyword;
    }
    @Override
    public void visit(File file) {
        if (file.getName().contains(keyword)) {
            System.out.println("Found in file: " + file.getName());
        }
    }
    @Override
    public void visit(Directory directory) {
        if (directory.getName().contains(keyword)) {
            System.out.println("Found in directory: " + directory.getName());
        }
    }
}
