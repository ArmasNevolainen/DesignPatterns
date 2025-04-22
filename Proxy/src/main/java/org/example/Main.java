package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addUnprotectedDocument(1, new Date(), "Public Document Content");
        library.addProtectedDocument(2, new Date(), "Protected Document Content", "John");

        User john = new User("John");
        User jack = new User("Jack");

        try {
            System.out.println("John reads doc 1: " + library.getDocument(1).getContent(john));
            System.out.println("Jack reads doc 1: " + library.getDocument(1).getContent(jack));
            System.out.println("John reads doc 2: " + library.getDocument(2).getContent(john));
            System.out.println("Jack reads doc 2: " + library.getDocument(2).getContent(jack));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
