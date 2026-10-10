import java.util.Arrays;

/**
 * Week 10 - DSA Fundamental Assignment Practice
 * Category C - Coding Assignment
 * Problem 4: Exam Score Band Counter
 * 
 * Task:
 * A university stores the marks of all students in an exam as an array sorted in ascending order;
 * marks can repeat. Faculty members frequently ask how many students scored within a band [low, high],
 * inclusive of both ends.
 * 
 * Implement a function countInBand(scores, low, high) that returns the number of scores s such that
 * low <= s <= high. The array is large and queried very often, so your solution must not scan the scores
 * one by one.
 * 
 * Constraints:
 * - 1 <= length of scores <= 10^6
 * - scores is sorted in ascending order
 * - 0 <= low <= high <= 100
 * 
 * Examples:
 * Sample 1:
 * scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 42, high = 58
 * Expected Output: 6
 * 
 * Sample 2:
 * scores = [35, 42, 42, 50, 58, 58, 58, 63, 71, 88], low = 90, high = 100
 * Expected Output: 0
 * 
 * Complexity Requirements & Duplicate Handling Explanation:
 * -------------------------------------------------------------------------------------------------
 * 1. Final Solution (Binary Search - lowerBound & upperBound):
 *    - Time Complexity: O(log N) per query. We perform two binary searches over an array of size N (up to 10^6).
 *    - Space Complexity: O(1) auxiliary space.
 * 
 * 2. Linear Scan Approach:
 *    - Time Complexity: O(N) per query. For N = 10^6 and frequent queries, scanning one by one is too slow
 *      and violates the problem requirement.
 *    - Space Complexity: O(1).
 * 
 * 3. Handling Duplicates at Band Edges:
 *    - Because scores can repeat, a standard binary search might stop at an arbitrary matching duplicate.
 *    - To ensure all duplicates of `low` are included, lowerBound finds the FIRST index where score >= low.
 *      When scores[mid] >= low, we continue searching in the left half (right = mid).
 *    - To ensure all duplicates of `high` are included, upperBound finds the FIRST index where score > high.
 *      When scores[mid] > high, we narrow down to the left half (right = mid); otherwise, we search right.
 *    - The count of elements in [low, high] is exactly: upperBound(high) - lowerBound(low).
 * -------------------------------------------------------------------------------------------------
 */

public class Question4_ExamScoreBandCounter {

    /**
     * Counts the number of scores in the inclusive range [low, high] in O(log N) time.
     * 
     * @param scores sorted array of student scores in ascending order
     * @param low lower bound of the score band (inclusive)
     * @param high upper bound of the score band (inclusive)
     * @return count of scores s such that low <= s <= high
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int lowerIndex = lowerBound(scores, low);
        int upperIndex = upperBound(scores, high);

        return upperIndex - lowerIndex;
    }

    /**
     * Finds the first index i such that scores[i] >= target.
     * If all elements are < target, returns scores.length.
     */
    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid; // Move left to find the first occurrence
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Finds the first index i such that scores[i] > target.
     * If all elements are <= target, returns scores.length.
     */
    private static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid; // Move left to find the first strictly greater element
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Exam Score Band Counter ===");

        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println("Sorted Scores: " + Arrays.toString(scores));

        // Sample 1
        int low1 = 42, high1 = 58;
        int res1 = countInBand(scores, low1, high1);
        System.out.println("\nSample 1: Band [" + low1 + ", " + high1 + "]");
        System.out.println("Expected Output: 6 | Actual Output: " + res1);

        // Sample 2
        int low2 = 90, high2 = 100;
        int res2 = countInBand(scores, low2, high2);
        System.out.println("\nSample 2: Band [" + low2 + ", " + high2 + "]");
        System.out.println("Expected Output: 0 | Actual Output: " + res2);

        // Additional Test Cases
        System.out.println("\nAdditional Test Cases:");
        // Single score matching exact duplicate
        System.out.println("Band [58, 58]: " + countInBand(scores, 58, 58) + " (Expected: 3)");

        // Full array range
        System.out.println("Band [0, 100]: " + countInBand(scores, 0, 100) + " (Expected: 10)");

        // Below lowest
        System.out.println("Band [10, 30]: " + countInBand(scores, 10, 30) + " (Expected: 0)");

        // Exact match on single element
        System.out.println("Band [35, 35]: " + countInBand(scores, 35, 35) + " (Expected: 1)");
    }
}
