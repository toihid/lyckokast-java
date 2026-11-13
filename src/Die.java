
package src;

import java.util.Random;

public class Die {

    private int value;
    private int sides;
    private Random random;

    // Create a die with the number of sides chosen
    public Die(int sides) {

        // Check that the die has at least one side
        if (sides < 1) {
            throw new IllegalArgumentException("Die must have at least 1 side.");
        }

        this.sides = sides;
        this.random = new Random();
    }

    // Return the current value of the die
    public int getValue() {
        return value;
    }

    // Return the number of sides
    public int getSides() {
        return sides;
    }

    // Roll the die and get a random number between 1 and the number of sides
    public void roll() {
        value = random.nextInt(sides) + 1;
    }
}
