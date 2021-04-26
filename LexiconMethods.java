/*
Programming assignment in the Lexicon course "Test och Bedömnning" by Jonas Renliden 20210422.
The program solves sixteen different tasks and provides a menu-system.
*/
package se.lexicon;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
All 16 tasks separated in 16 methods. I choose to put all of the methods in a separate class to not clutter up the code in the Menu class.
In another project I wouldn't have had a class called Methods but I found it appropriate in this assignment considering the wide span of
tasks without connection to anything else. As the instructions for the implementation left a lot of freedom I chose to let my creativity go wild,
adding some functionality and different error handling behaviour for different methods, as I saw fit. I also chose to go with void for all methods
to keep most of the functionality, like println, inside the methods.
 */
public class LexiconMethods implements Methods {

    private static final String ANSI_RED = "\u001B[31m"; //Used for changing text colour of the output, not system independent and will not work in
    // for example Windows command prompt, didn't find an easy way to change colour of the output without using external libraries.
    private static final String ANSI_RESET = "\u001B[0m";
    private boolean textColour = true;

    //1. Funktion som skriver ut ”Hello World” i konsolen.
    @Override
    public void helloWorld() {
        System.out.println("Hello World");
    }

    //2. Funktion som tar in input från användaren (Förnamn, Efternamn, Ålder) och sedan skriver ut dessa i konsolen.
    @Override
    public void userData(Scanner scanner) {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your age: ");
        String age = scanner.nextLine();
        System.out.println("Your name is " + firstName + " " + lastName + ", and your age is " + age + ".");
    }

    //3. Funktion som ändrar färgen på texten i konsolen (och ändrar tillbaka om man använder funktionen igen).
    @Override
    public void textColour() {
        if (textColour) {
            System.out.print(ANSI_RED);
            textColour = false;
        } else {
            System.out.print(ANSI_RESET);
            textColour = true;
        }

        System.out.println("You changed the text-colour :D");
    }

    //4. Funktion för att skriva ut dagens datum.
    @Override
    public void date() {
        System.out.println("Today's date is: " + new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
    }

    //5. Funktion som tar två input värden, sedan skriver ut vilket av dem som är störst.
    @Override
    public void biggestNumber(Scanner scanner) {
        int firstNumber;
        int secondNumber;

        try {
            System.out.print("Enter a number: ");
            firstNumber = scanner.nextInt();
            System.out.print("Enter another number: ");
            secondNumber = scanner.nextInt();
            if (firstNumber == secondNumber)
                System.out.println("The numbers are equal.");
            else if (firstNumber < secondNumber)
                System.out.println(secondNumber + " is the bigger number.");
            else
                System.out.println(firstNumber + " is the bigger number.");
        } catch (Exception e) {
            System.out.println("Wrong input, exiting to main menu");
        }finally {
            scanner.nextLine();

        }
    }

    /*
     6. Funktion som genererar att slumpmässigt tal mellan 1 och 100. Användaren ska sedan gissa talet. Gissar användaren rätt så ska ett meddelande säga detta,
     samt hur många försök det tog. Gissar användaren fel ska ett meddelande visas som informerar ifall talet var för stort eller för litet
    */
    @Override
    public void guessTheNumber(Scanner scanner) {
        int theNumber = new Random().nextInt(100) + 1;
        int count = 0;
        System.out.println("Guess the number, enter a number between 1 and 100, hit 0 to quit.");

        while (true) {
            if (scanner.hasNextInt()) {
                count++;
                int inputNumber = scanner.nextInt();

                if(inputNumber > theNumber)
                    System.out.println("Your guess is to high, try again.");
                else if (inputNumber < theNumber && inputNumber!= 0)
                    System.out.println("Your guess is to low, try again.");
                else if (inputNumber == 0) {
                    scanner.nextLine();
                    break;
                }
                else if (theNumber == inputNumber) {
                    System.out.println("Congratulations, you guessed the right number! It took you " + count + " guesses.");
                    scanner.nextLine();
                    break;
                }
            } else {
                System.out.println("Wrong input, try again!");
                scanner.nextLine();
            }
        }
    }

    //7. Funktion där användaren skriver in en textrad, som sedan sparas i en fil på hårddisken.
    @Override
    public void writeToFile(Scanner scanner) {
        System.out.print("Write something: ");
        String textInput = scanner.nextLine();
        try {
            File txtFile = new File("txtfile.txt");
            txtFile.createNewFile();

            FileWriter fileWriter = new FileWriter(txtFile);
            fileWriter.write(textInput);
            fileWriter.close();

            System.out.println("Your input " + textInput + " has been saved to " + txtFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //8. Funktion där en fil läses in från hårddisken (för enkelhetens skull kan man använda filen från uppgift 7)
    @Override
    public void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("txtFile.txt"));
            String fileText = reader.readLine();
            reader.close();
            System.out.println("The text in the file reads \"" + fileText + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //9. Funktion där användaren skickar in ett decimaltal och får tillbaka roten ur, upphöjt till 2 och upphöjt till 10
    @Override
    public void squarerootAndExponents(Scanner scanner) {
        System.out.print("Enter a double: ");
        while (true) {
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                var doubleArray = new double[]{Math.sqrt(number), Math.pow(number, 2), Math.pow(number, 10)};
                System.out.print("Square root of " + number + " is " + doubleArray[0] + ", exponentiation with 2 is " + doubleArray[1] +
                        " and exponentiation with 10 is " + doubleArray[2]);
                scanner.nextLine();
                System.out.println();
                break;

            } else {
                System.out.println("Wrong input, try again!");
                scanner.nextLine();

            }
        }


    }

    /*
    10. Funktion där programmet skriver ut en multiplikationstabell från 1 till 10. En ”tab” ska läggas in efter varje nummer.
     Försöka att ställa upp det så det blir relativt läsbart.
    */
    @Override
    public void multiplicationTable() {
        int[] numbers = new int[10];
        String bold = "\033[0;1m";

        for (int i = 0; i < 10; i++) {
            numbers[i] = i + 1;
            System.out.print("\t" + bold + numbers[i]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.print(bold + numbers[i] + ANSI_RESET);
            for (int j = 0; j < 10; j++) {
                System.out.print("\t" + numbers[i] * numbers[j]);
            }
        }
        System.out.println();
    }

    //11. Funktion som skapar två arrayer. Den första fylls med slumpmässiga tal. Den andra fylls med talen från den första i stigande ordning.
    @Override
    public void numbers() {
        int[] arrayOne = new int[10];
        int[] arrayTwo = new int[10];
        Random rand = new Random();
        System.out.print("First array: ");
        for (int i = 0; i < 10; i++) {
            arrayOne[i] = rand.nextInt(100) + 1;
            System.out.print(arrayOne[i] + " ");
            arrayTwo[i] = arrayOne[i];
        }

        System.out.println();
        System.out.print("Second array: ");

        Arrays.stream(arrayTwo).sorted().forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    //12. Funktion som tar en input från användaren och kontrollerar ifall det är en palindrom (alltså samma ord från båda håll, såsom Anna eller radar.
    @Override
    public void palindrome(Scanner scanner) {
        System.out.print("Write something: ");
        String textInput = scanner.nextLine();
        StringBuilder reverse = new StringBuilder();
        int stringLength = textInput.length();

        for (int i = stringLength - 1; i >= 0; i--)
            reverse.append(textInput.charAt(i));

        if (textInput.equals(reverse.toString()))
            System.out.println("This is a palindrome.");
        else
            System.out.println("This isn't a palindrome.");
    }

    //13. Funktion som tar två inputs från användaren och skriver sedan ut alla siffror som är mellan de två inputsen.
    @Override
    public void rangeOfNumbers(Scanner scanner) {
        int firstNumber;
        int secondNumber;
        int swap;

        while (true) {
            try {
                System.out.print("Enter a number: ");
                firstNumber = scanner.nextInt();
                System.out.print("Enter another number: ");
                secondNumber = scanner.nextInt();
                if (firstNumber == secondNumber)
                    System.out.println("The numbers are equal.");
                else if (firstNumber > secondNumber) {
                    swap = firstNumber;
                    firstNumber = secondNumber;
                    secondNumber = swap;

                    System.out.print("Range of all numbers: ");
                    for (int i = firstNumber; i <= secondNumber; i++)
                        System.out.print(i + " ");

                    scanner.nextLine();
                    System.out.println();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Wrong input, try again!");
                scanner.nextLine();
            }
        }
    }

    /*
    14. Funktion där användaren skickar in ett antal värden (komma-separerade siffror) som sedan sorteras och skrivs ut efter udda och jämna värden.
    Task seemed easy enough but turn out to be quite complicated and one of the largest methods, might have overcomplicated it.
    */
    @Override
    public void oddsAndEvens(Scanner scanner) {
        try {
            System.out.println("Enter some comma-separated numbers: ");
            String input = scanner.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
            int[] numbers = new int[stringTokenizer.countTokens()];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            var evenNumbers = new ArrayList<Integer>();
            var oddNumbers = new ArrayList<Integer>();

            for (int number : numbers) {
                if (number % 2 == 0)
                    evenNumbers.add(number);
                else
                    oddNumbers.add(number);
            }

            System.out.print("These numbers are odd: ");
            oddNumbers.forEach(x -> System.out.print(x + " "));
            System.out.println();
            System.out.print("These numbers are even: ");
            evenNumbers.forEach(x -> System.out.print(x + " "));
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("Wrong input, exiting to main menu");
        }
    }

    //15. Funktion där användaren skriver in ett antal värden (komma-separerade siffor) som sedan adderas och skrivs ut.
    @Override
    public void addition(Scanner scanner) {
        try {
            System.out.println("Enter some comma-separated numbers: ");
            String input = scanner.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
            int addedNumbers = 0;
            int[] numbers = new int[stringTokenizer.countTokens()];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
                addedNumbers += numbers[i];
            }

            System.out.println("The sum of these numbers is: " + addedNumbers);


        } catch (NumberFormatException e) {
            System.out.println("Wrong input, exiting to main menu");
        }
    }

    /*
    16. Funktion där användaren ska ange namnet på sin karaktär och namnet på en motståndare. Funktionen skall sedan själv lägga till
     slumpmässiga värden för Hälsa, Styrka och Tur, som sparas i en instans av en klass.
    */
    @Override
    public void heroAndFoe(Scanner scanner) {
        String heroName;
        String foeName;
        String lineSeparator = System.lineSeparator(); //System independent lineseperator for better presentation on different systems.

        System.out.print("Enter your character name: ");
        heroName = scanner.nextLine();
        System.out.print("Enter the name of your foe: ");
        foeName = scanner.nextLine();

        Character hero = new Character(heroName);
        Character foe = new Character(foeName);

        System.out.print(lineSeparator + "Your hero" + lineSeparator + "Name: " + hero.getName() + lineSeparator + "Health: "
                + hero.getHealth() + lineSeparator + "Strength: " + hero.getStrenght() + lineSeparator + "Luck: " + hero.getLuck()
                + lineSeparator + lineSeparator + "Your foe" + lineSeparator + "Name: " + foe.getName() + lineSeparator + "Health: "
                + foe.getHealth() + lineSeparator + "Strenght: " + foe.getStrenght() + lineSeparator + "Luck: " + foe.getLuck() + lineSeparator);
    }
}



