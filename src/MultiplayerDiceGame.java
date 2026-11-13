
package src;

import java.util.Scanner;
import java.util.ArrayList;

public class MultiplayerDiceGame {

    public static void play(Scanner scanner) {

        System.out.println("Welcome to Multiplayer!");

        // Create the players and give them their dice
        ArrayList<Player> players = initialize(scanner);

        // Ask how many rounds we want to play
        int numberOfRounds = getValidInt(
                scanner, "How many rounds do you want to play? ", 1, 100);

        // Play all the rounds
        for (int round = 1; round <= numberOfRounds; round++) {

            System.out.println("\nRound " + round);

            // Let each player roll their dice
            takeTurn(players, scanner);
        }

        // Show the final score for each player
        System.out.println("\nFinal Scores:");

        for (Player player : players) {
            System.out.println(player.getName() + ": "
                    + player.getScore() + " points");
        }

        // Find the player or players with the highest score
        ArrayList<Player> winners = getWinners(players);

        System.out.println("\nWinner(s):");

        for (Player winner : winners) {
            System.out.println(winner.getName() + " with "
                    + winner.getScore() + " points!");
        }
    }

    // Create the players and find out how many dice they should have
    private static ArrayList<Player> initialize(Scanner scanner) {

        ArrayList<Player> players = new ArrayList<>();

        int numberOfPlayers = getValidInt(
                scanner, "How many players want to play? ", 2, 10);

        // Ask for each player's name and create a Player object
        for (int i = 0; i < numberOfPlayers; i++) {

            String name = getValidName(
                    scanner, "Enter name for player " + (i + 1) + ": ");

            Player player = new Player(name);
            players.add(player);
        }

        // Give every player the same number of six-sided dice
        int numberOfDice = getValidInt(
                scanner, "How many dice should each player have? ", 1, 10);

        for (Player player : players) {

            for (int i = 0; i < numberOfDice; i++) {
                player.addDie(6);
            }
        }

        return players;
    }

    // Read an integer within the allowed range
    private static int getValidInt(
            Scanner scanner, String message, int min, int max) {

        while (true) {

            System.out.print(message);

            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Input was closed.");
            }

            String input = scanner.nextLine().trim();

            try {

                int number = Integer.parseInt(input);

                if (number >= min && number <= max) {
                    return number;
                }

                System.out.println(
                        "Invalid input! Enter a number between "
                                + min + " and " + max + ".");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a whole number.");
            }
        }
    }

    // Read a non-empty player name
    private static String getValidName(
            Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Input was closed.");
            }

            String name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println(
                    "Name cannot be empty. Please try again.");
        }
    }

    // Let every player roll their dice once
    private static void takeTurn(
            ArrayList<Player> players, Scanner scanner) {

        for (Player player : players) {

            System.out.println("\n" + player.getName() + "'s turn!");
            System.out.println("Press Enter to roll your dice...");

            // Wait until the player presses Enter
            scanner.nextLine();

            // Roll all the player's dice and calculate the total
            player.rollDice();
            int total = player.getDiceTotal();

            // Add the dice total to the player's score
            player.increaseScore(total);

            System.out.println(player.getName() + " rolled: " + total);
        }
    }

    // Find all players who have the highest score
    private static ArrayList<Player> getWinners(
            ArrayList<Player> players) {

        ArrayList<Player> winners = new ArrayList<>();

        // Protect against an empty player list
        if (players.isEmpty()) {
            return winners;
        }

        // Find the highest score
        int highestScore = players.get(0).getScore();

        for (Player player : players) {

            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }

        // Add all players with the highest score to the winners list
        for (Player player : players) {

            if (player.getScore() == highestScore) {
                winners.add(player);
            }
        }

        return winners;
    }
}
