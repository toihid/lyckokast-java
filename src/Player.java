package src;
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
