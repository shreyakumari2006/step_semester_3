import java.util.Arrays;

/**
 * Problem 3: Top-3 Podium Finder
 * 
 * Problem Statement:
 * With hundreds of teams submitting scores, sorting the entire array just to find the top 3
 * podium finishers is overkill — a judge on stage wants the podium announced the instant scoring
 * wraps up, without waiting for a full sort. Find the top 3 scores in a single pass through the array.
 * 
 * Requirements:
 * - Do not sort the array and do not use Arrays.sort(...) — track the top 3 scores as you scan once, left to right.
 * - Return the three scores in descending order.
 * 
 * Function Signature(s):
 * static int[] findTopThreeScores(int[] scores)
 * 
 * Examples:
 * Input: {45, 82, 79, 90, 33, 90, 61}
 * Output: [90, 90, 82]
 * 
 * Explanation:
 * Two teams tied for the top score (90), so both appear — the third-place score is 82, not 79,
 * since a genuine tie for first still only leaves one "true" second-highest slot for 82 to claim.
 * 
 * Constraints:
 * scores.length is at least 3, up to 10,000.
 */

public class Question3_Top3PodiumFinder {

    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Scores array must contain at least 3 elements.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        // Single pass O(N) scan without sorting
        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score >= third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top-3 Podium Finder ===");

        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input scores: " + Arrays.toString(scores));

        int[] topThree = findTopThreeScores(scores);
        System.out.println("Top 3 scores: " + Arrays.toString(topThree));
    }
}
