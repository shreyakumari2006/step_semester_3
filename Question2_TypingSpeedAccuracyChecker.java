import java.util.Locale;

/**
 * Question 2: The Typing Speed Test Accuracy Checker
 * 
 * Scenario:
 * An online typing-practice website shows users a fixed passage and asks them to retype it as
 * quickly and accurately as they can. Once the user submits their attempt, the system compares
 * it character by character against the original passage and reports exactly how accurate the
 * attempt was — along with the position of the very first mistake.
 */
public class Question2_TypingSpeedAccuracyChecker {

    /**
     * Compares original and typed strings, calculates accuracy percentage, and reports first mismatch if any.
     * 
     * @param original The original passage string.
     * @param typed    The user's typed text string.
     */
    public static void checkTypingAccuracy(String original, String typed) {
        // Validation: Check for null inputs
        if (original == null || typed == null) {
            System.out.println("Invalid Input: Strings cannot be null.");
            return;
        }

        // Validation: Check for equal length
        if (original.length() != typed.length()) {
            System.out.println("Invalid Input: Original and typed strings must be of equal length.");
            return;
        }

        int total = original.length();
        if (total == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPosition = -1;
        char originalMismatchChar = '\0';
        char typedMismatchChar = '\0';

        // Traverse character by character
        for (int i = 0; i < total; i++) {
            char origChar = original.charAt(i);
            char typeChar = typed.charAt(i);

            if (origChar == typeChar) {
                matchedCount++;
            } else if (firstMismatchPosition == -1) {
                // Record the first mismatch position (1-based index)
                firstMismatchPosition = i + 1;
                originalMismatchChar = origChar;
                typedMismatchChar = typeChar;
            }
        }

        // Calculate accuracy percentage
        double accuracy = ((double) matchedCount / total) * 100.0;

        // Build output
        String mismatchInfo;
        if (firstMismatchPosition == -1) {
            mismatchInfo = "No Mismatches";
        } else {
            mismatchInfo = String.format("First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPosition, originalMismatchChar, typedMismatchChar);
        }

        System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | %s%n",
                matchedCount, total, accuracy, mismatchInfo);
    }

    public static void main(String[] args) {
        System.out.println("=== Question 2: Typing Speed Test Accuracy Checker ===");

        // Test Case 1: Mismatch present
        String orig1 = "hello world";
        String typed1 = "hello worlt";
        System.out.println("\nTest Case 1 Input: original=\"" + orig1 + "\", typed=\"" + typed1 + "\"");
        System.out.print("Output: ");
        checkTypingAccuracy(orig1, typed1);

        // Test Case 2: Perfect match
        String orig2 = "coding";
        String typed2 = "coding";
        System.out.println("\nTest Case 2 Input: original=\"" + orig2 + "\", typed=\"" + typed2 + "\"");
        System.out.print("Output: ");
        checkTypingAccuracy(orig2, typed2);

        // Test Case 3: Early mismatch
        String orig3 = "JavaProgramming";
        String typed3 = "JaveProgramming";
        System.out.println("\nTest Case 3 Input: original=\"" + orig3 + "\", typed=\"" + typed3 + "\"");
        System.out.print("Output: ");
        checkTypingAccuracy(orig3, typed3);
    }
}
