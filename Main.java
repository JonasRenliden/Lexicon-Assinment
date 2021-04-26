/*
Programming assignment in the Lexicon course "Test och Bedömnning" by Jonas Renliden 20210422.
The program solves sixteen different tasks and provides a menu-system.
*/

package se.lexicon;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu(new Scanner(System.in), new String[]{"1. Hello world", "2. User data", "3. Text colour", "4. Date", "5. Biggest number", "6. Guess the number",
                "7. Write to file", "8. Read from file", "9. Square root and exponents", "10. Multiplication table", "11. Numbers", "12. Palindrome",
                "13. Range of numbers", "14. Odds and evens", "15. Addition", "16. Hero and foe"}, new LexiconMethods());

        menu.runMenu();
    }
}
