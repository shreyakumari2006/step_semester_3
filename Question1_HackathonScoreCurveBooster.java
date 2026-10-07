import java.util.Arrays;

/**
 * Problem 1: Hackathon Score Curve Booster
 * 
 * Problem Statement:
 * The judging panel at a campus hackathon realizes the coding round was tougher than intended,
 * and wants to give every team a flat bonus before the final leaderboard is printed. Write a method
 * that boosts every score in place — no new array, no return value needed — and print the result
 * using the standard library's own formatting helper.
 * 
 * Requirements:
 * - curveScores(...) must modify the caller's original array directly — it should return nothing at all.
 * - Use Arrays.toString(...) to print the final leaderboard, rather than looping and printing manually.
 * 
 * Function Signature(s):
 * static void curveScores(int[] scores, int bonus)
 * 
 * Examples:
 * Input:
 * int[] scores = {70, 85, 60};
 * curveScores(scores, 10);
 * Arrays.toString(scores);
 * Output: "[80, 95, 70]"
 * 
 * Constraints:
 * scores.length up to 200. bonus is a non-negative integer.
 */

public class Question1_HackathonScoreCurveBooster {

    public static void curveScores(int[] scores, int bonus) {
        if (scores == null || bonus <= 0) {
            return;
        }
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Hackathon Score Curve Booster ===");

        int[] scores = {70, 85, 60};
        System.out.println("Original scores: " + Arrays.toString(scores));

        int bonus = 10;
        curveScores(scores, bonus);

        String result = Arrays.toString(scores);
        System.out.println("Curved scores: " + result);
    }
}
