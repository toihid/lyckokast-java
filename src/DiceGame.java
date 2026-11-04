package src;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lyckokast!");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("How many rounds do you want to play? ");
        int rounds = scanner.nextInt();

        System.out.print("How many sides should the die have? ");
        int sides = scanner.nextInt();

        Player player = new Player(name);
        player.addDie(sides);

        int round = 1;

        while (round <= rounds) {
            System.out.println("Round " + round);

            System.out.print("Guess the dice value: ");
            int guess = scanner.nextInt();

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