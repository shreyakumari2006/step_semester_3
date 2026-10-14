import java.util.Arrays;
public class Question1_FantasyTeamScoreMultiplier {

    /**
     * Applies 2x multiplier for the captain and 1.5x multiplier for the vice-captain
     * directly to the playerScores array.
     * 
     * @param playerScores      Array of player scores to modify in-place.
     * @param captainIndex      Index of the captain (2x multiplier).
     * @param viceCaptainIndex  Index of the vice-captain (1.5x multiplier).
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        // Apply captain multiplier (2.0x)
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        // Apply vice-captain multiplier (1.5x)
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fantasy Team Score Multiplier ===");

        // Example 1
        double[] scores1 = {40.0, 55.0, 30.0, 62.0};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(scores1) + ", captainIndex=1, viceCaptainIndex=3");
        applyMultipliers(scores1, 1, 3);
        System.out.println("Output: " + Arrays.toString(scores1));

        // Test Case 2
        double[] scores2 = {100.0, 20.0, 80.0, 45.0, 50.0};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(scores2) + ", captainIndex=0, viceCaptainIndex=2");
        applyMultipliers(scores2, 0, 2);
        System.out.println("Output: " + Arrays.toString(scores2));

        // Test Case 3: Boundary lineup
        double[] scores3 = {10.0, 25.0};
        System.out.println("\nTest Case 3 Input: " + Arrays.toString(scores3) + ", captainIndex=1, viceCaptainIndex=0");
        applyMultipliers(scores3, 1, 0);
        System.out.println("Output: " + Arrays.toString(scores3));
    }
}
