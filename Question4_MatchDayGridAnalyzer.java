import java.util.Arrays;

/**
 * Problem 4: Match Day Grid Analyzer
 * Category C Assignment Problems - Intermediate Tier
 * 
 * Topics Integrated:
 * 2D Arrays, User-Defined Methods (reused), Loops
 * 
 * Problem Statement:
 * A cricket stats app logs runs scored in every over of every match as a grid — one row per match,
 * one column per over. The app wants to flag which matches were genuine "Power Surge" innings
 * (a high scoring rate throughout) without repeating the same averaging code once per match.
 * 
 * Requirements:
 * - Write a private helper, rowAverage(int[] row), and call it once per match from the main method
 *   — do not recompute an average inline more than once.
 * - A match averaging at or above the threshold is a "Power Surge"; below it, "Normal".
 */
public class Question4_MatchDayGridAnalyzer {

    /**
     * Helper method to compute the average runs per over for a single match row.
     * 
     * @param row Array representing runs in each over of a match.
     * @return The average runs per over.
     */
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    /**
     * Classifies each match as either "Power Surge" or "Normal" based on whether
     * the average runs per over is at or above the threshold.
     * 
     * @param runsPerOver 2D array where each row represents runs scored per over in a match.
     * @param threshold   The scoring rate threshold for Power Surge.
     * @return Formatted classification summary across all matches.
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(status);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Match Day Grid Analyzer ===");

        // Test Case 1: Example from assignment
        int[][] runs1 = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold1 = 8;
        System.out.println("\nTest Case 1 Input: " + Arrays.deepToString(runs1) + ", threshold=" + threshold1);
        System.out.println("Output: " + classifyMatches(runs1, threshold1));

        // Test Case 2: Ragged 2D array with varying overs
        int[][] runs2 = {
            {12, 15, 9, 14},
            {6, 7},
            {8, 8, 8, 8, 8}
        };
        int threshold2 = 8;
        System.out.println("\nTest Case 2 Input: " + Arrays.deepToString(runs2) + ", threshold=" + threshold2);
        System.out.println("Output: " + classifyMatches(runs2, threshold2));
    }
}
