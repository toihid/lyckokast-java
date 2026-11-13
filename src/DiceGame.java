
package src;

import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lyckokast!");

        // Ask for the player's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Ask how many rounds the player wants to play
        int rounds = 0;

        while (rounds <= 0) {

            System.out.print("How many rounds do you want to play? ");

            if (scanner.hasNextInt()) {
                rounds = scanner.nextInt();

                if (rounds <= 0) {
                    System.out.println("Please enter a number greater than 0.");
                }

            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
        }

        // Ask how many sides the die should have
        int sides = 0;

        while (sides < 2) {

            System.out.print("How many sides should the die have? ");

            if (scanner.hasNextInt()) {
                sides = scanner.nextInt();

                if (sides < 2) {
                    System.out.println("The die must have at least 2 sides.");
                }

            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
        }

        // Create the player and give them one die
        Player player = new Player(name);
        player.addDie(sides);

        // Play the selected number of rounds
        int round = 1;

        while (round <= rounds) {

            System.out.println("\nRound " + round);

            // Ask the player to guess the dice value
            int guess = 0;

            while (guess < 1 || guess > sides) {

                System.out.print("Guess the dice value: ");

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();

                    if (guess < 1 || guess > sides) {
                        System.out.println(
                            "Please enter a number between 1 and " + sides
                        );
                    }

                } else {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next();
                }
            }

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

            round++;
        }

        // Show the final result
        System.out.println("\nGame over!");
        System.out.println("Final score: " + player.getScore());

        scanner.close();
    }
}
