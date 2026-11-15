
package src;

import java.util.Scanner;
import java.util.ArrayList;

public class PigGame {

    public static void play(Scanner scanner) {

        System.out.println("\nWelcome to Pig Game!");
        System.out.println("First player to reach 100 points wins!");
        System.out.println("Roll a 1 and you lose your turn points!\n");

        // Ask how many players and create them
        ArrayList<Player> players = new ArrayList<>();

        int numberOfPlayers = getValidInt(
                scanner, "How many players? (2-10): ", 2, 10);

        // Create each player and give them a six-sided die
        for (int i = 0; i < numberOfPlayers; i++) {

            String name = getValidName(
                    scanner, "Enter name for player " + (i + 1) + ": ");

            Player player = new Player(name);
            player.addDie(6);
            players.add(player);
        }

        // Keep playing until someone reaches 100 points
        boolean someoneWon = false;

        while (!someoneWon) {

            // Let each player take their turn
            for (Player player : players) {

                System.out.println("\n--- " + player.getName() + "'s turn ---");
                System.out.println("Total score: " + player.getScore());

                // Play one turn and get the points they earned
                int pointsThisTurn = playOneTurn(player, scanner);

                // Check if player wants to quit
                if (pointsThisTurn == -1) {
                    System.out.println("Game ended.");
                    return;
                }

                // Add the points to their total score
                if (pointsThisTurn > 0) {
                    player.increaseScore(pointsThisTurn);
                    System.out.println(player.getName() + " earned " 
                            + pointsThisTurn + " points this turn!");
                    System.out.println("New total: " + player.getScore());
                }

                // Did this player win?
                if (player.getScore() >= 100) {
                    System.out.println("\n" + player.getName() 
                            + " wins with " + player.getScore() + " points!");
                    someoneWon = true;
                    break;
                }
            }
        }
    }

    // Let one player play their turn
    // They can keep rolling or stop
    // Returns how many points they got
    private static int playOneTurn(Player player, Scanner scanner) {

        int pointsThisTurn = 0;

        // Keep asking if they want to roll or stop
        while (true) {

            System.out.print("\nRoll the die? (Enter = roll, 's' = stop, 'q' = quit): ");

            if (!scanner.hasNextLine()) {
                return 0;
            }

            String input = scanner.nextLine().trim().toLowerCase();

            // Player typed 's' - they want to stop and keep their points
            if (input.equals("s")) {
                System.out.println(player.getName() + " stops with " 
                        + pointsThisTurn + " turn points.");
                return pointsThisTurn;
            }

            // Player typed 'q' - they want to quit the game
            if (input.equals("q")) {
                System.out.println("\nQuitting game...");
                return -1; // Signal to quit
            }

            // Roll the die and see what we got
            player.rollDice();
            int result = player.getDiceTotal();

            System.out.println("You rolled: " + result);

            // If they rolled a 1, they lose everything!
            if (result == 1) {
                System.out.println("Oh no! You rolled a 1!");
                System.out.println("You lose all " + pointsThisTurn + " turn points!");
                return 0;
            }

            // Add the roll to their turn points
            pointsThisTurn = pointsThisTurn + result;
            System.out.println("Turn points so far: " + pointsThisTurn);
        }
    }

    // Ask for a number and make sure it's valid
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

    // Ask for a name and make sure it's not empty
    private static String getValidName(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Input was closed.");
            }

            String name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name cannot be empty. Please try again.");
        }
    }
}

