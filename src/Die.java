package src;
import java.util.Random;
 
public class Die {
    private int value;
    private int sides;
    private Random random;
 
    public Die(int sides) {
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