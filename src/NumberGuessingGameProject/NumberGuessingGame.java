package NumberGuessingGameProject;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create a Random object to generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100

        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        final int maxAttempts = 10; // Maximum number of attempts
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        // Loop for multiple attempts
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            // Compare the user's guess with the generated number
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You've guessed the number correctly.");
                guessedCorrectly = true;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
        }

        // Close the scanner
        scanner.close();
    }
}

