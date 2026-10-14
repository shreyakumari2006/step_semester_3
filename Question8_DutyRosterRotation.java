import java.util.Arrays;

/**
 * Week 10 - DSA Fundamental Assignment Practice
 * Category C - Coding Assignment
 * Problem 8: Duty Roster Rotation
 * 
 * Task:
 * A hostel rotates its cleaning duty roster every week by moving each name k places to the right;
 * names that go past the end wrap around to the front.
 * 
 * Implement a function rotateRoster(names, k) that returns the roster after rotating it to the right
 * by k places. k may be larger than the number of names.
 * 
 * Constraints:
 * - 1 <= length of names <= 100
 * - 0 <= k <= 10^9
 * 
 * Examples:
 * Sample 1:
 * names = ["A", "B", "C", "D", "E"], k = 2
 * Expected Output: ["D", "E", "A", "B", "C"]
 * 
 * Sample 2:
 * names = ["A", "B", "C", "D", "E"], k = 7
 * Expected Output: ["D", "E", "A", "B", "C"] // 7 places is the same as 2 (7 % 5 = 2)
 * 
 * Complexity Requirements & Analysis:
 * -------------------------------------------------------------------------------------------------
 * 1. Optimal Modulo Index Mapping Solution (Our Approach):
 *    - Time Complexity: O(N) — We compute k % N in O(1) and directly map each element to its final
 *      position (i + k) % N in a single pass of length N.
 *    - Space Complexity: O(N) auxiliary space to construct and return the newly rotated array.
 * 
 * 2. Why Rotating One Place at a Time, k Times, is Inefficient:
 *    - Shifting an array of size N by 1 position requires shifting all N elements, taking O(N) work.
 *    - Repeating this step k times without modulo reduction leads to a total time complexity of O(k * N).
 *    - When k is up to 10^9 and N = 100, k * N = 10^11 operations, which will cause Time Limit Exceeded (TLE)
 *      taking several minutes instead of milliseconds.
 *    - Applying effective rotation k_eff = k % N cancels out all full 360-degree cycles (where rotating N
 *      times returns the array to its original order) and reduces the required work to a single O(N) pass.
 * -------------------------------------------------------------------------------------------------
 */

public class Question8_DutyRosterRotation {

    /**
     * Rotates the given array of names k places to the right using O(N) modulo mapping.
     * 
     * @param names original array of names
     * @param k number of places to rotate right (can be up to 10^9)
     * @return a new array representing the rotated roster
     */
    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length == 0) {
            return new String[0];
        }

        int n = names.length;
        // Eliminate complete cycles
        int effectiveK = (int) (((long) k) % n);
        if (effectiveK < 0) {
            effectiveK += n;
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 8: Duty Roster Rotation ===");

        // Sample 1
        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;
        System.out.println("Sample 1 Input: names = " + Arrays.toString(names1) + ", k = " + k1);
        String[] result1 = rotateRoster(names1, k1);
        System.out.println("Expected Output: [D, E, A, B, C] | Actual Output: " + Arrays.toString(result1));

        // Sample 2
        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;
        System.out.println("\nSample 2 Input: names = " + Arrays.toString(names2) + ", k = " + k2);
        String[] result2 = rotateRoster(names2, k2);
        System.out.println("Expected Output: [D, E, A, B, C] | Actual Output: " + Arrays.toString(result2));

        // Edge Cases
        // Large k = 10^9
        int largeK = 1_000_000_000;
        System.out.println("\nEdge Case (Large k = 10^9): names = " + Arrays.toString(names1) + ", k = " + largeK);
        String[] resultLargeK = rotateRoster(names1, largeK);
        System.out.println("Actual Output (instant O(N)): " + Arrays.toString(resultLargeK));

        // k = 0 (No rotation)
        System.out.println("\nEdge Case (k = 0): " + Arrays.toString(rotateRoster(names1, 0)));

        // k = n (Full cycle)
        System.out.println("Edge Case (k = n = 5): " + Arrays.toString(rotateRoster(names1, 5)));

        // Single element array
        String[] single = {"OnlyHosteller"};
        System.out.println("Edge Case (Single element, k = 12345): " + Arrays.toString(rotateRoster(single, 12345)));
    }
}
