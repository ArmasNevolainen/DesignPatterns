package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Character Development Game!");
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        Character character = new Character(name);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("\n" + character.getStatus());

            if (character.getState() instanceof MasterState) {
                System.out.println("\nCongratulations! You have reached the Master level and completed the game!");
                gameRunning = false;
                continue;
            }

            System.out.println("\nAvailable actions:");
            System.out.println("1. Train");

            if (!(character.getState() instanceof NoviceState)) {
                System.out.println("2. Meditate");
            }

            if (character.getState() instanceof ExpertState || character.getState() instanceof MasterState) {
                System.out.println("3. Fight");
            }

            System.out.println("0. Exit");

            System.out.print("\nChoose an action: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                case 0:
                    System.out.println("Exiting game. Goodbye!");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
