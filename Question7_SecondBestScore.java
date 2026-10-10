import java.util.Arrays;

/**
 * Week 10 - DSA Fundamental Assignment Practice
 * Category C - Coding Assignment
 * Problem 7: Second-Best Score
 * 
 * Task:
 * A quiz app stores the scores of all players in an array. Prizes go to the top two different scores,
 * so the app needs the second-highest distinct score. If every player has the same score, there is no
 * second-highest score.
 * 
 * Implement a function secondHighest(scores) that returns the second-highest distinct score, or -1 if
 * it does not exist.
 * 
 * Constraints:
 * - 1 <= length of scores <= 1000
 * - 0 <= scores[i] <= 100
 * - Do not sort the array
 * 
 * Examples:
 * Sample 1:
 * scores = [45, 78, 92, 78, 60]
 * Expected Output: 78
 * 
 * Sample 2:
 * scores = [50, 50, 50]
 * Expected Output: -1
 * 
 * Complexity Requirements & Comparison:
 * -------------------------------------------------------------------------------------------------
 * 1. Single-Pass Iteration (Our Implemented Approach):
 *    - Time Complexity: O(N) — We scan the array once from left to right, performing constant-time O(1)
 *      comparisons and updates per element.
 *    - Space Complexity: O(1) — Only two scalar variables (highest and second) are maintained, using no
 *      extra memory.
 * 
 * 2. Sorting-Based Approach (Disallowed by Constraint):
 *    - Time Complexity: O(N log N) — Sorting the entire array requires O(N log N) time, followed by up to
 *      O(N) to locate the first distinct smaller element.
 *    - Space Complexity: O(N) or O(log N) depending on sort implementation (e.g. Dual-Pivot Quicksort / Timsort).
 *    - Comparison: The single-pass approach is asymptotically faster (O(N) vs O(N log N)) and adheres to
 *      the strict problem requirement not to mutate or sort the input array.
 * -------------------------------------------------------------------------------------------------
 */

public class Question7_SecondBestScore {

    /**
     * Finds the second-highest distinct score in a single O(N) pass.
     * 
     * @param scores array of player scores (0 <= scores[i] <= 100)
     * @return the second-highest distinct score, or -1 if it does not exist
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
            // Note: If score == highest or score <= second, it is skipped (handling duplicates).
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 7: Second-Best Score ===");

        // Sample 1
        int[] sample1 = {45, 78, 92, 78, 60};
        System.out.println("Sample 1 Input: " + Arrays.toString(sample1));
        int result1 = secondHighest(sample1);
        System.out.println("Expected Output: 78 | Actual Output: " + result1);

        // Sample 2
        int[] sample2 = {50, 50, 50};
        System.out.println("\nSample 2 Input: " + Arrays.toString(sample2));
        int result2 = secondHighest(sample2);
        System.out.println("Expected Output: -1 | Actual Output: " + result2);

        // Additional Edge Cases
        int[] singleElement = {100};
        System.out.println("\nEdge Case (Single element): " + Arrays.toString(singleElement));
        System.out.println("Output: " + secondHighest(singleElement));

        int[] twoElements = {80, 95};
        System.out.println("\nEdge Case (Two distinct elements): " + Arrays.toString(twoElements));
        System.out.println("Output: " + secondHighest(twoElements));

        int[] tiesForHighest = {100, 100, 90, 80};
        System.out.println("\nEdge Case (Ties for highest): " + Arrays.toString(tiesForHighest));
        System.out.println("Output: " + secondHighest(tiesForHighest));
    }
}
