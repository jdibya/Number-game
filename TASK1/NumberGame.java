import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println("===== Welcome to the Number Guessing Game! =====");
        System.out.println("I will pick a number between 1 and 100. Try to guess it!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round! You have " + maxAttempts + " attempts.");

            while (attemptsUsed < maxAttempts) {
                System.out.print("Enter your guess (1-100): ");
                int guess;
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                attemptsUsed++;

                if (guess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attemptsUsed));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Sorry! You've used all attempts. The number was: " + targetNumber);
            }

            totalRounds++;

            System.out.println("\nYour Score:");
            System.out.println("Rounds Played: " + totalRounds);
            System.out.println("Rounds Won: " + roundsWon);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing! Final Score:");
        System.out.println("Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Goodbye!");
        scanner.close();
    }
}
