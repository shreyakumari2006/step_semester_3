import java.util.Arrays;

/**
 * Problem 3: Top Performer Tracker
 * Category C Assignment Problems - Intermediate Tier
 * 
 * Topics Integrated:
 * Arrays, Loops, Logical Thinking
 * 
 * Problem Statement:
 * A fantasy league's weekly recap wants to instantly call out the week's standout performer
 * and the week's biggest disappointment, along with how wide the gap between them was — without
 * sorting the entire scoreboard just to read off two numbers.
 * 
 * Requirements:
 * - Do not sort the array — find the minimum and maximum in a single pass through the array.
 * - Report the minimum, the maximum, and the spread (max - min) together.
 */
public class Question3_TopPerformerTracker {

    /**
     * Finds the minimum score, maximum score, and the spread (max - min) in a single pass.
     * 
     * @param scores Array of player scores.
     * @return Formatted string: "Min: <min> | Max: <max> | Spread: <spread>".
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "Invalid Input";
        }

        int min = scores[0];
        int max = scores[0];

        // Single pass through array to track min and max simultaneously
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top Performer Tracker ===");

        // Test Case 1: Example from assignment
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(scores1));
        System.out.println("Output: " + findMinMaxSpread(scores1));

        // Test Case 2: Array with 2 elements
        int[] scores2 = {15, 85};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(scores2));
        System.out.println("Output: " + findMinMaxSpread(scores2));

        // Test Case 3: All identical elements
        int[] scores3 = {50, 50, 50, 50};
        System.out.println("\nTest Case 3 Input: " + Arrays.toString(scores3));
        System.out.println("Output: " + findMinMaxSpread(scores3));
    }
}
