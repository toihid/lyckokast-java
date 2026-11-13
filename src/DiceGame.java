
package src;

import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lyckokast!");

        System.out.print("Enter your name: \n");
        String name = scanner.nextLine();

        // Validate number of rounds
        int rounds = 0;

        while (rounds <= 0) {
            System.out.print("How many rounds do you want to play? \n");

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

        // Validate number of dice sides
        int sides = 0;

        while (sides < 2) {
            System.out.print("How many sides should the die have? \n");

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

        Player player = new Player(name);
        player.addDie(sides);

        int round = 1;

        while (round <= rounds) {

            System.out.println("Round " + round);

            // Validate player's guess
            int guess = 0;

            while (guess < 1 || guess > sides) {
                System.out.print("Guess the dice value: \n");

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

            player.rollDice();

            int result = player.getDieValue();

            System.out.println("The dice rolled: " + result);

            if (guess == result) {
                System.out.println("You guessed correctly!");
                player.increaseScore();
            } else {
                System.out.println("Wrong guess!");
            }

            System.out.println("Your score: " + player.getScore());

            round++;
        }

        System.out.println("Game over!");
        System.out.println("Final score: " + player.getScore());

        scanner.close();
    }
}
