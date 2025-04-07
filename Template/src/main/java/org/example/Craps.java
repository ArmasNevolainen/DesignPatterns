package org.example;

import java.util.Random;
import java.util.Scanner;

public class Craps extends Game {
    private int numberOfPlayers;
    private int[] points;
    private int[] roundPoints;
    private int[] wins;
    private Random random;

    public Craps(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.points = new int[numberOfPlayers];
        this.wins = new int[numberOfPlayers];
        this.roundPoints = new int[numberOfPlayers];
    }

    public void initializeGame(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            points[i] = 0;
            wins[i] = 0;
            roundPoints[i] = 0;
        }
    }

    public boolean endOfGame() {

        int maxWins = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (wins[i] > maxWins) {
                maxWins = wins[i];
            }
        }

        int playersWithMaxWins = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (wins[i] == maxWins) {
                playersWithMaxWins++;
            }
        }

        if (playersWithMaxWins == 1 && maxWins > 0) {
            int secondMostWins = 0;
            for (int i = 0; i < numberOfPlayers; i++) {
                if (wins[i] < maxWins && wins[i] > secondMostWins) {
                    secondMostWins = wins[i];
                }
            }

            return (maxWins - secondMostWins) >= 2;
        }

        return false;
    }

    public void playSingleTurn(int player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + (player + 1) + "'s turn. Press Enter to roll the dice...");
        scanner.nextLine();
        int roll = rollDice();
        roundPoints[player] = roll;
        points[player] += roll;
        System.out.println("Player " + (player + 1) + " rolled: " + roll);
        if (roll == 12) {
            wins[player]++;
        }
        if (player == numberOfPlayers - 1) {
            determineRoundWinner();
        }
    }

    private int rollDice() {
        if (random == null) {
            random = new Random();
        }
        return random.nextInt(6) + 1 + random.nextInt(6) + 1;
    }

    private void determineRoundWinner() {
        int maxPoints = 0;
        int winnerIndex = -1;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (roundPoints[i] > maxPoints) {
                maxPoints = roundPoints[i];
                winnerIndex = i;
            }
        }

        boolean isTie = false;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i != winnerIndex && roundPoints[i] == maxPoints) {
                isTie = true;
                break;
            }
        }

        if (!isTie && winnerIndex != -1) {
            wins[winnerIndex]++;
            System.out.println("Player " + (winnerIndex + 1) + " wins this round with " + maxPoints + " points!");
            System.out.println("Player " + (winnerIndex + 1) + " now has " + wins[winnerIndex] + " wins.");
        } else {
            System.out.println("This round ended in a tie with " + maxPoints + " points.");
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            roundPoints[i] = 0;
        }

        System.out.println("--- End of Round ---");
    }

    public void displayWinner() {
        int maxWins = 0;
        int winnerIndex = -1;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (wins[i] > maxWins) {
                maxWins = wins[i];
                winnerIndex = i;
            }
        }

        if (winnerIndex != -1) {
            System.out.println("\n=== GAME OVER ===");
            System.out.println("Player " + (winnerIndex + 1) + " is the overall winner with " + maxWins + " round wins!");
            System.out.println("\nFinal scores:");
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("Player " + (i + 1) + ": " + points[i] + " total points, " + wins[i] + " round wins");
            }
        } else {
            System.out.println("No winner determined.");
        }
    }
}
