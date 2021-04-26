/*
Programming assignment in the Lexicon course "Test och Bedömnning" by Jonas Renliden 20210422.
The program solves sixteen different tasks and provides a menu-system.
*/

package se.lexicon;

import java.util.Random;

public class Character {
    private static final Random rand = new Random();

    private final String name;
    private final int health;
    private final int strength;
    private final int luck;

    public Character(String name) {
        this.name = name;
        this.health = rollDice();
        this.strength = rollDice();
        this.luck = rollDice();
    }

    private static int rollDice(){
        return 3 * (rand.nextInt(6) +1); //Chose to go with a classic 3d6 roll for stats :D
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrenght() {
        return strength;
    }

    public int getLuck() {
        return luck;
    }


}
