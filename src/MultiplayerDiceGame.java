
package src;

import java.util.Scanner;
import java.util.ArrayList;

public class MultiplayerDiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Multiplayer Dice Game!");

        // Create the players and give them their dice
        ArrayList<Player> players = initialize(scanner);

        // Ask how many rounds we want to play
        System.out.print("How many rounds do you want to play? ");
        int numberOfRounds = scanner.nextInt();
        scanner.nextLine();

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

        scanner.close();
    }

    // Create the players and find out how many dice they should have
    private static ArrayList<Player> initialize(Scanner scanner) {

        System.out.print("How many players want to play? ");
        int numberOfPlayers = scanner.nextInt();

        ArrayList<Player> players = new ArrayList<>();

        // Ask for each player's name and create a Player object
        for (int i = 0; i < numberOfPlayers; i++) {

            System.out.print("Enter name for player " + (i + 1) + ": ");
            String name = scanner.next();

            Player player = new Player(name);
            players.add(player);
        }

        // Give every player the same number of six-sided dice
        System.out.print("How many dice should each player have? ");
        int numberOfDice = scanner.nextInt();

        for (Player player : players) {

            for (int i = 0; i < numberOfDice; i++) {
                player.addDie(6);
            }
        }

        return players;
    }

    // Let every player roll their dice once
    private static void takeTurn(ArrayList<Player> players, Scanner scanner) {

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
    private static ArrayList<Player> getWinners(ArrayList<Player> players) {

        ArrayList<Player> winners = new ArrayList<>();

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
