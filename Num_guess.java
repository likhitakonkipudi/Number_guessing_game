import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int lower = 1;
        int upper = 100;
        int maxTries = 7;
        int number = rand.nextInt(upper - lower + 1) + lower;

        int attempts = 0;
        boolean guessed = false;

        System.out.println("Guess the number between " + lower + " and " + upper + ".");
        System.out.println("You have " + maxTries + " chances.");

        while (attempts < maxTries) {
            System.out.print("Your guess: ");
            String input = scanner.nextLine();

            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (guess < lower || guess > upper) {
                System.out.println("Guess must be between " + lower + " and " + upper + ".");
                continue;
            }

            attempts++;

            if (guess == number) {
                System.out.println("Correct! You guessed it in " + attempts + " tries.");
                guessed = true;
                break;
            } else if (guess < number) {
                System.out.println("Too low.");
            } else {
                System.out.println("Too high.");
            }
        }

        if (!guessed) {
            System.out.println("Out of tries. The number was " + number + ".");
        }

        scanner.close();
    }
}
