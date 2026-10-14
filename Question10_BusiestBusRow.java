import java.util.Arrays;

/**
 * Week 10 - DSA Fundamental Assignment Practice
 * Category C - Coding Assignment
 * Problem 10: Busiest Bus Row
 * 
 * Task:
 * A college bus records how many students sit in each seat as a 2D grid, where each row is one row of seats.
 * The transport office wants to know which row carries the most students.
 * 
 * Implement a function busiestRow(grid) that returns the index of the row with the largest total and that total.
 * If two rows tie, return the one with the smaller index.
 * 
 * Constraints:
 * - 1 <= rows, columns <= 10
 * - 0 <= grid[i][j] <= 3
 * 
 * Example:
 * grid = [
 *   [2, 0, 1],
 *   [3, 3, 1],
 *   [1, 1, 1]
 * ]
 * Expected Output: Row 1, Total 7
 * 
 * Complexity Requirements & Analysis:
 * -------------------------------------------------------------------------------------------------
 * 1. Time Complexity:
 *    - O(r * c), where r is the number of rows and c is the number of columns in the grid.
 *    - Every seat (cell) in the 2D grid is visited and summed exactly once using nested loops.
 * 
 * 2. Space Complexity:
 *    - O(1) auxiliary space — only two integer trackers (bestRowIndex and maxTotal) and a loop accumulator
 *      are used.
 * 
 * 3. Tie-Breaking Strategy:
 *    - By updating the maxTotal and bestRowIndex ONLY when rowSum > maxTotal (strictly greater),
 *      any subsequent row that produces an equal sum is ignored, naturally preserving the smallest row index.
 * -------------------------------------------------------------------------------------------------
 */

public class Question10_BusiestBusRow {

    /**
     * Finds the index and student total of the busiest row in the bus grid.
     * Ties are broken by choosing the smaller row index.
     * 
     * @param grid 2D array representing student seat counts
     * @return formatted string: "Row X, Total Y"
     */
    public static String busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return "Row 0, Total 0";
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            if (grid[r] != null) {
                for (int seats : grid[r]) {
                    rowSum += seats;
                }
            }

            // Update only if strictly greater to ensure the smaller index is kept on ties
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRowIndex = r;
            }
        }

        return "Row " + bestRowIndex + ", Total " + maxTotal;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 10: Busiest Bus Row ===");

        // Sample 1
        int[][] sample1 = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        System.out.println("Sample 1 Grid:");
        for (int[] row : sample1) {
            System.out.println(Arrays.toString(row));
        }
        String result1 = busiestRow(sample1);
        System.out.println("Expected Output: Row 1, Total 7");
        System.out.println("Actual Output:   " + result1);

        // Additional Test Case 1: Tie Breaking (Row 0 and Row 2 have same total of 6)
        int[][] tieCase = {
            {3, 3}, // sum = 6 (index 0)
            {1, 2}, // sum = 3 (index 1)
            {3, 3}  // sum = 6 (index 2)
        };
        System.out.println("\nTie-Breaking Test Grid (Row 0 and Row 2 tie with 6):");
        for (int[] row : tieCase) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Output (should pick Row 0): " + busiestRow(tieCase));

        // Additional Test Case 2: Single Row
        int[][] singleRow = {
            {2, 3, 1, 0}
        };
        System.out.println("\nSingle Row Test Grid: " + Arrays.toString(singleRow[0]));
        System.out.println("Output: " + busiestRow(singleRow));

        // Additional Test Case 3: Empty bus (all zeros)
        int[][] allZeros = {
            {0, 0},
            {0, 0}
        };
        System.out.println("\nAll Zeros Grid: Row 0 vs Row 1 tie with 0");
        System.out.println("Output: " + busiestRow(allZeros));
    }
}
