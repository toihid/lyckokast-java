package src;
import java.util.Random;
 
public class Die {
    private int value;
    private int sides;
    private Random random;
 
    public Die(int sides) {
        if(sides< 1) {
            throw new IllegalArgumentException("Die must have at least 1 side.");
        }
        this.sides = sides;
        random = new Random();
    }
 
    public int getValue() {
        return value;
    }
 
    public int getSides() {
        return sides;
    }
 
    public void roll() {
        value = random.nextInt(sides) + 1;
    }
}