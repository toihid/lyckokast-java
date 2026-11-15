# lyckokast-java
A fun Java dice game where players guess the roll and test their luck! 🎲

## Technologies Used

- **Java** - Core programming language
- **Scanner** - For handling user input
- **ArrayList** - Dynamic collections for managing players and dice
- **Random** - Generating random dice rolls
- **Exception Handling** - Input validation and error management

A simple dice game I made for my Java class. Players can guess what the die will roll or compete with friends. The name "Lyckokast" means "lucky throw" in Swedish.

## What it does

There are three ways to play:
- **Single Player** - Try to guess what the die will roll before it happens
- **Multiplayer** - Roll dice with friends and see who gets the highest total
- **Pig Game** - Risk vs reward! Keep rolling to build points, but roll a 1 and lose everything

## How to run it

First, compile the code:
```bash
cd src
javac DiceGame.java
```

Then run it:
```bash
java src.DiceGame
```

## The Files

- `DiceGame.java` - Has the main method and runs the single player game
- `MultiplayerDiceGame.java` - Handles the multiplayer game
- `PigGame.java` - The classic Pig dice game
- `Player.java` - Keeps track of each player's name, score, and dice
- `Die.java` - Makes a die that can roll random numbers

## Single Player

You pick how many rounds you want and how many sides the die should have. Then you try to guess what it will roll each time. You get a point if you guess right.

## Multiplayer

Up to 10 people can play. Everyone gets the same number of dice and rolls them each round. Whoever has the most points at the end wins. If there's a tie, everyone with the top score wins together.

## Pig Game

This is a classic dice game where you race to 100 points. On your turn, you keep rolling a die and adding to your temporary points. You can stop anytime to save your points, or keep rolling to get more. But if you roll a 1, you lose all your temporary points for that turn! It's all about knowing when to stop.

## Examples

### Single Player Example

```
Welcome to Lyckokast!

1. Single Player
2. Multiplayer
3. Exit

Choose an option (1-3): 1

Welcome to Single Player!
Enter your name: Alice
How many rounds do you want to play? 3
How many sides should the die have? 6

Round 1
Guess the dice value (1-6): 4
The dice rolled: 4
You guessed correctly!
Your score: 1

Round 2
Guess the dice value (1-6): 2
The dice rolled: 5
Wrong guess!
Your score: 1

Round 3
Guess the dice value (1-6): 6
The dice rolled: 6
You guessed correctly!
Your score: 2

Game over!
Final score: 2
```

### Multiplayer Example

```
Welcome to Lyckokast!

1. Single Player
2. Multiplayer
3. Exit

Choose an option (1-3): 2

Welcome to Multiplayer!
How many players want to play? 3
Enter name for player 1: Alice
Enter name for player 2: Bob
Enter name for player 3: Charlie
How many dice should each player have? 2
How many rounds do you want to play? 2

Round 1

Alice's turn!
Press Enter to roll your dice...

Alice rolled: 8

Bob's turn!
Press Enter to roll your dice...

Bob rolled: 5

Charlie's turn!
Press Enter to roll your dice...

Charlie rolled: 11

Round 2

Alice's turn!
Press Enter to roll your dice...

Alice rolled: 6

Bob's turn!
Press Enter to roll your dice...

Bob rolled: 9

Charlie's turn!
Press Enter to roll your dice...

Charlie rolled: 7

Final Scores:
Alice: 14 points
Bob: 14 points
Charlie: 18 points

Winner(s):
Charlie with 18 points!
```

### Pig Game Example

```
Welcome to Lyckokast!

1. Single Player
2. Multiplayer
3. Pig Game
4. Exit

Choose an option (1-4): 3

Welcome to Pig Game!
First player to reach 100 points wins!
Roll a 1 and you lose your turn points!

How many players? (2-10): 2
Enter name for player 1: Alice
Enter name for player 2: Bob

--- Alice's turn ---
Total score: 0

Roll the die? (Enter = roll, 's' = stop): 
You rolled: 4
Turn points so far: 4

Roll the die? (Enter = roll, 's' = stop): 
You rolled: 6
Turn points so far: 10

Roll the die? (Enter = roll, 's' = stop): s
Alice stops with 10 turn points.
Alice earned 10 points this turn!
New total: 10

--- Bob's turn ---
Total score: 0

Roll the die? (Enter = roll, 's' = stop): 
You rolled: 5
Turn points so far: 5

Roll the die? (Enter = roll, 's' = stop): 
You rolled: 1
Oh no! You rolled a 1!
You lose all 5 turn points!

--- Alice's turn ---
Total score: 10
...

🎉 Alice wins with 102 points!
```

### Exit Example

```
Welcome to Lyckokast!

1. Single Player
2. Multiplayer
3. Pig Game
4. Exit

Choose an option (1-4): 4
Goodbye!
```

## What I learned

This was good practice for working with classes, ArrayLists, and handling user input in Java. I also got better at validating input and organizing code into different methods.

## Challenges I faced

**Input validation** - At first, the game would crash if someone typed letters instead of numbers. I had to learn how to use try-catch blocks with `NumberFormatException` to handle bad input and keep asking until the user enters something valid.

**Handling multiple winners** - I initially only thought about one winner, but then realized multiple players could tie with the same score. I had to rewrite the winner logic to find the highest score first, then loop through again to collect all players who have that score.

**Scanner management** - I ran into issues when the Scanner would close unexpectedly or when there was no more input. Adding the `hasNextLine()` check and throwing an `IllegalStateException` helped make the code more robust.

**Code reusability** - Both game modes needed similar input validation, so instead of copying the same code twice, I created the `getValidInt()` method that both classes could use. This made the code cleaner and easier to maintain.
