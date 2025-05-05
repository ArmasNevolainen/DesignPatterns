package org.example;

import java.util.*;

public class Main {
    private static final List<Recommendation> recommendations = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View Recommendations");
            System.out.println("2. Clone & Modify Recommendation");
            System.out.println("3. Create New Recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1": viewRecommendations(); break;
                case "2": cloneAndModify(); break;
                case "3": createNewRecommendation(); break;
                case "4": System.exit(0);
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void seedData() {
        Recommendation teens = new Recommendation("Teens");
        teens.addBook(new Book("Suzanne Collins", "The Hunger Games", "Dystopian", 2008));
        teens.addBook(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997));
        recommendations.add(teens);

        Recommendation adults = new Recommendation("Adults");
        adults.addBook(new Book("George Orwell", "1984", "Dystopian", 1949));
        adults.addBook(new Book("Harper Lee", "To Kill a Mockingbird", "Classic", 1960));
        recommendations.add(adults);
    }

    private static void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
            return;
        }
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + recommendations.get(i).getTargetAudience());
        }
        System.out.print("View details of which recommendation? (number, or 0 to go back): ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx >= 0 && idx < recommendations.size()) {
            System.out.println(recommendations.get(idx));
        }
    }

    private static void cloneAndModify() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations to clone.");
            return;
        }
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + recommendations.get(i).getTargetAudience());
        }
        System.out.print("Clone which recommendation? (number): ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= recommendations.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Recommendation cloned = recommendations.get(idx).clone();
        System.out.print("Enter new target audience (or press Enter to keep '" + cloned.getTargetAudience() + "'): ");
        String audience = scanner.nextLine();
        if (!audience.trim().isEmpty()) cloned.setTargetAudience(audience.trim());

        while (true) {
            System.out.println("\nCurrent Recommendation:");
            System.out.println(cloned);
            System.out.println("a) Add Book");
            System.out.println("b) Remove Book");
            System.out.println("c) Save & Exit");
            System.out.print("Choose an option: ");
            String opt = scanner.nextLine();
            if ("a".equalsIgnoreCase(opt)) {
                Book book = inputBook();
                cloned.addBook(book);
            } else if ("b".equalsIgnoreCase(opt)) {
                List<Book> books = cloned.getBooks();
                for (int i = 0; i < books.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + books.get(i));
                }
                System.out.print("Remove which book? (number): ");
                int bidx = Integer.parseInt(scanner.nextLine()) - 1;
                if (bidx >= 0 && bidx < books.size()) {
                    cloned.removeBook(books.get(bidx));
                }
            } else if ("c".equalsIgnoreCase(opt)) {
                recommendations.add(cloned);
                System.out.println("Recommendation saved.");
                break;
            }
        }
    }

    private static void createNewRecommendation() {
        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine();
        Recommendation rec = new Recommendation(audience);
        while (true) {
            System.out.println("\nCurrent Recommendation:");
            System.out.println(rec);
            System.out.println("a) Add Book");
            System.out.println("b) Save & Exit");
            System.out.print("Choose an option: ");
            String opt = scanner.nextLine();
            if ("a".equalsIgnoreCase(opt)) {
                Book book = inputBook();
                rec.addBook(book);
            } else if ("b".equalsIgnoreCase(opt)) {
                recommendations.add(rec);
                System.out.println("Recommendation saved.");
                break;
            }
        }
    }

    private static Book inputBook() {
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Publication Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        return new Book(author, title, genre, year);
    }
}
