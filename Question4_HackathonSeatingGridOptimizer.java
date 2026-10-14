/**
 * Problem 4: Hackathon Seating Grid Optimizer
 * 
 * Problem Statement:
 * The venue is arranged as a grid of seating rows, and organizers want to walk the floor toward
 * the rows where teams are visibly struggling (to offer mentor help) versus the rows that are
 * humming along fine. Classify every row using one small, reusable helper method rather than
 * repeating the averaging logic for each row by hand.
 * 
 * Requirements:
 * - Write a private helper, rowAverage(int[] row), and call it once per row from the main method —
 *   do not recompute an average inline more than once.
 * - A row averaging below the threshold is a "Quiet Zone"; at or above it, a "Buzzing Zone".
 * 
 * Function Signature(s):
 * static double rowAverage(int[] row)
 * static String classifyRows(int[][] seatingScores, int threshold)
 * 
 * Examples:
 * Input:
 * {
 *   {40, 50, 45},
 *   {85, 90, 95},
 *   {30, 20, 25}
 * }, threshold = 60
 * Output: "Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone"
 * 
 * Constraints:
 * Rows may vary in length (a jagged grid) — do not assume every row has the same number of columns.
 */

public class Question4_HackathonSeatingGridOptimizer {

    // Helper method to compute the average of a row
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Hackathon Seating Grid Optimizer ===");

        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        String classification = classifyRows(seatingScores, threshold);
        System.out.println("Output:\n\"" + classification + "\"");
    }
}
