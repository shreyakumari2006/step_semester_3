import java.util.Scanner;

/**
 * Question 1: The Exam Hall Seat Duplication Checker
**/
public class Question1_ExamHallSeatDuplicationChecker {

    /**
     * Checks for duplicate seat numbers in the provided array.
     * 
     * @param seatNumbers Array of seat numbers (integers) assigned to students.
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        // Validation: Check for null or empty array
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("Invalid Input: Seat numbers array cannot be null or empty.");
            return;
        }

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
         
            boolean alreadyProcessed = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyProcessed = true;
                    break;
                }
            }

            if (alreadyProcessed) {
                continue;
            }

            // Check if seatNumbers[i] appears again later in the array
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break; // Move to the next unique seat number
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Question 1: Exam Hall Seat Duplication Checker ===");

        // Test Case 1: Has duplicates
        int[] test1 = {101, 102, 103, 102, 105};
        System.out.println("\nTest Case 1 Input: {101, 102, 103, 102, 105}");
        System.out.print("Output: ");
        checkDuplicateSeats(test1);

        // Test Case 2: No duplicates
        int[] test2 = {101, 102, 103, 104, 105};
        System.out.println("\nTest Case 2 Input: {101, 102, 103, 104, 105}");
        System.out.print("Output: ");
        checkDuplicateSeats(test2);

        // Test Case 3: Multiple different duplicates
        int[] test3 = {201, 202, 201, 203, 202, 204};
        System.out.println("\nTest Case 3 Input: {201, 202, 201, 203, 202, 204}");
        System.out.print("Output: ");
        checkDuplicateSeats(test3);
    }
}
