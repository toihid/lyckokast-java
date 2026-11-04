package src;
import java.util.Random;
 
public class Die {

    private int value;

    private int sides;

    private Random random;
 
    public Die(int sides) {

        this.sides = sides;

        this.random = new Random();

        roll();

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
 
public class Player {

    private String name;

    private int score;

    private Die die;
 
    public Player(String name) {

        this.name = name;

        this.score = 0;

    }
 
    public String getName() {

        return name;

    }
 
    public int getScore() {

        return score;

    }
 
    public void setScore(int score) {

        this.score = score;

    }
 
    public void rollDice() {

        die.roll();

    }
 
    public int getDieValue() {

        return die.getValue();

    }
 
    public void increaseScore() {

        score++;

    }
 
    public void addDie(int numberOfSides) {

        die = new Die(numberOfSides);

    }

}
 
