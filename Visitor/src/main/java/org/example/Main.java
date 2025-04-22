package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("notes.txt", 100);
        File file2 = new File("report.doc", 200);
        File file3 = new File("photo.jpg", 300);

        Directory subDir = new Directory("docs", Arrays.asList(file2));
        Directory root = new Directory("root", Arrays.asList(file1, subDir, file3));

        // Test SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize());

        // Test SearchVisitor
        System.out.println("Searching for 'doc':");
        SearchVisitor searchVisitor = new SearchVisitor("doc");
        root.accept(searchVisitor);

        System.out.println("Searching for 'notes':");
        SearchVisitor searchVisitor2 = new SearchVisitor("notes");
        root.accept(searchVisitor2);
    }
}
