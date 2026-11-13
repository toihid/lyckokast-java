
package src;

import java.util.ArrayList;

public class Player {

    private String name;
    private int score;
    private ArrayList<Die> dice;

    // Create a player with a name, zero points and an empty dice list
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.dice = new ArrayList<>();
    }

    // Return the player's name
    public String getName() {
        return name;
    }

    // Return the player's current score
    public int getScore() {
        return score;
    }

    // Set the player's score
    public void setScore(int score) {
        this.score = score;
    }

    // Roll all the dice that belong to the player
    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }

    // Add together the values of all the player's dice
    public int getDiceTotal() {
        int total = 0;

        for (Die die : dice) {
            total += die.getValue();
        }

        return total;
    }

    // Increase the score by one point (used in DiceGame)
    public void increaseScore() {
        score++;
    }

    // Add a specific number of points (used in MultiplayerDiceGame)
    public void increaseScore(int amount) {
        score += amount;
    }

    // Create a new die and add it to the player's dice list
    public void addDie(int numberOfSides) {
        dice.add(new Die(numberOfSides));
    }
}
