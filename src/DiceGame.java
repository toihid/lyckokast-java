
package src;

import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lyckokast!");
        System.out.println();
        System.out.println("1. Single Player");
        System.out.println("2. Multiplayer");
        System.out.println("3. Exit");

        String choice;

        // Ask for a valid menu option
        while (true) {

            System.out.print("\nChoose an option (1-3): ");
            choice = scanner.nextLine().trim();

            if (choice.equals("1") ||
                choice.equals("2") ||
                choice.equals("3")) {
                break;
            }

            System.out.println(
                    "Invalid option! Please choose 1, 2 or 3.");
        }

        switch (choice) {

            case "1":
                play(scanner);
                break;

            case "2":
                MultiplayerDiceGame.play(scanner);
                break;

            case "3":
                System.out.println("Goodbye!");
                break;
        }

        scanner.close();
    }

    // Single Player game
    private static void play(Scanner scanner) {

        System.out.println("\nWelcome to Single Player!");

        // Ask for a valid player name
        String name;

        do {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println(
                        "Name cannot be empty. Please try again.");
            }

        } while (name.isEmpty());

        // Ask how many rounds the player wants to play
        int rounds = getValidInt(
                scanner, "How many rounds do you want to play? ", 1, 100);

        // Ask how many sides the die should have
        int sides = getValidInt(
                scanner, "How many sides should the die have? ", 2, 100);

        // Create the player and give them one die
        Player player = new Player(name);
        player.addDie(sides);

        // Play the selected number of rounds
        for (int round = 1; round <= rounds; round++) {

            System.out.println("\nRound " + round);

            // Ask the player to guess the dice value
            int guess = getValidInt(
                    scanner,
                    "Guess the dice value (1-" + sides + "): ",
                    1,
                    sides);

            // Roll the die and get the result
            player.rollDice();

            int result = player.getDiceTotal();

            System.out.println("The dice rolled: " + result);

            // Check if the player's guess was correct
            if (guess == result) {
                System.out.println("You guessed correctly!");
                player.increaseScore();
            } else {
                System.out.println("Wrong guess!");
            }

            // Show the current score
            System.out.println("Your score: " + player.getScore());
        }

        // Show the final result
        System.out.println("\nGame over!");
        System.out.println("Final score: " + player.getScore());
    }

    // Read an integer within the allowed range
    private static int getValidInt(
            Scanner scanner, String message, int min, int max) {

        while (true) {

            System.out.print(message);

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
}
