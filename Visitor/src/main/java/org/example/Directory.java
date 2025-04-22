package org.example;

import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements;
    public Directory(String name, List<FileSystemElement> elements) {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }

    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}
