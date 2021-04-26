/*
Programming assignment in the Lexicon course "Test och Bedömnning" by Jonas Renliden 20210422.
The program solves sixteen different tasks and provides a menu-system.
*/

package se.lexicon;
import java.util.Scanner;

/*
Decided to use an Interface for loser couplings, pretty useless at this stage but could be useful
 if you would like to have a method class with other functionality. For example showing the method output on a website.
 */
public interface Methods {
    void helloWorld();

    void userData(Scanner scanner);

    void textColour();

    void date();

    void biggestNumber(Scanner scanner);

    void guessTheNumber(Scanner scanner);

    void writeToFile(Scanner scanner);

    void readFromFile();

    void squarerootAndExponents(Scanner scanner);

    void multiplicationTable();

    void numbers();

    void palindrome(Scanner scanner);

    void rangeOfNumbers(Scanner scanner);

    void oddsAndEvens(Scanner scanner);

    void addition(Scanner scanner);

    void heroAndFoe(Scanner scanner);
}
