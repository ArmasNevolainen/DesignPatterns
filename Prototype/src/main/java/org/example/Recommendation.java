package org.example;


import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>(books);
    }
    public String getTargetAudience() { return targetAudience; }
    public void setTargetAudience(String targetAudience) { this.targetAudience = targetAudience; }

    public List<Book> getBooks() { return books; }

    public void addBook(Book book) { books.add(book); }
    public void removeBook(Book book) { books.remove(book); }

    @Override
    public Recommendation clone() {
        List<Book> clonedBooks = new ArrayList<>();
        for (Book book : books) {
            clonedBooks.add(book.clone());
        }
        return new Recommendation(targetAudience, clonedBooks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for ").append(targetAudience).append(":\n");
        if (books.isEmpty()) {
            sb.append("  No books in this recommendation yet.\n");
        } else {
            for (Book book : books) {
                sb.append("  - ").append(book).append("\n");
            }
        }
        return sb.toString();
    }
}
