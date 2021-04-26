/*
Programming assignment in the Lexicon course "Test och Bedömnning" by Jonas Renliden 20210422.
The program solves sixteen different tasks and provides a menu-system.
*/

package se.lexicon;
import java.util.Scanner;

public class Menu {
    private static final String ERROR_MESSAGE = "\nInvalid input! Please enter a number between 1 and 16, or 0 to quit.\n";
    private final Scanner scanner;
    private final String[] menuChoices;
    private final Methods methods;

    public Menu(Scanner scanner, String[] menuChoices, Methods methods) {
        this.scanner = scanner;
        this.menuChoices = menuChoices;
        this.methods = methods;
    }
/*
Presents all the menu-choices and logic for calling all methods by user-input. Runs until the user quits by hitting 0.
 */
    public void runMenu() {
        while (true) {

            System.out.println("\nMain menu");
            for (String menuChoice : menuChoices)
                System.out.println(menuChoice);

            System.out.print("\nMake your choice, type 0 to quit: ");

            if (scanner.hasNext("([0-9]|1[0-6])")) { //only executes by a valid menu-choice, 1 to 16.
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0)
                    System.exit(0);

                System.out.println(); //Blank line for esthetics, common in this code.
                System.out.println(menuChoices[choice - 1]); //Printing the headline of the choice.

                switch (choice) {
                    case 1 -> methods.helloWorld();
                    case 2 -> methods.userData(scanner);
                    case 3 -> methods.textColour();
                    case 4 -> methods.date();
                    case 5 -> methods.biggestNumber(scanner);
                    case 6 -> methods.guessTheNumber(scanner);
                    case 7 -> methods.writeToFile(scanner);
                    case 8 -> methods.readFromFile();
                    case 9 -> methods.squarerootAndExponents(scanner);
                    case 10 -> methods.multiplicationTable();
                    case 11 -> methods.numbers();
                    case 12 -> methods.palindrome(scanner);
                    case 13 -> methods.rangeOfNumbers(scanner);
                    case 14 -> methods.oddsAndEvens(scanner);
                    case 15 -> methods.addition(scanner);
                    case 16 -> methods.heroAndFoe(scanner);
                }

            } else {
                System.out.println(ERROR_MESSAGE);
                scanner.nextLine(); //Flushes the new line character so in won't be handled by later input readings, common in this code.
            }

            System.out.println("\nHit enter to go back to the main menu.");
            scanner.nextLine(); //In this case is waits for the user to hit Enter before showing the menu, to make it easier to read the result of the last task.
        }
    }
}



