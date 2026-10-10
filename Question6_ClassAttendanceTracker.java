import java.util.Arrays;

/**
 * Week 10 - DSA Fundamental Assignment Practice
 * Category C - Coding Assignment
 * Problem 6: Class Attendance Tracker
 * 
 * Task:
 * A teacher records attendance for one student as an array of 1s (present) and 0s (absent), one value per day.
 * The teacher wants to know how many days the student was present and the longest run of days the student
 * attended without a break.
 * 
 * Implement a function attendanceSummary(days) that returns the number of present days and the length
 * of the longest unbroken run of present days.
 * 
 * Constraints:
 * - 1 <= length of days <= 100
 * - Each value is 0 or 1
 * 
 * Examples:
 * Sample 1:
 * days = [1, 1, 0, 1, 1, 1, 0, 1]
 * Expected Output: Present: 6, Longest streak: 3
 * 
 * Sample 2:
 * days = [0, 0, 0]
 * Expected Output: Present: 0, Longest streak: 0
 * 
 * Complexity Requirements & Single-Pass Verification:
 * -------------------------------------------------------------------------------------------------
 * 1. Single-Pass Efficiency:
 *    - Yes, both the total present count and the longest streak can be determined simultaneously in a
 *      single linear pass.
 *    - Time Complexity: O(N) — We scan the array of size N exactly once.
 *    - Space Complexity: O(1) — We only maintain three scalar integer variables: presentCount,
 *      currentStreak, and longestStreak.
 * 
 * 2. Logic:
 *    - On encountering 1: Increment presentCount and currentStreak; update longestStreak = max(longestStreak, currentStreak).
 *    - On encountering 0: Reset currentStreak = 0.
 * -------------------------------------------------------------------------------------------------
 */

public class Question6_ClassAttendanceTracker {

    /**
     * Calculates the total present days and the longest consecutive attendance streak in O(N) time and O(1) space.
     * 
     * @param days array of 1s (present) and 0s (absent)
     * @return formatted summary string: "Present: X, Longest streak: Y"
     */
    public static String attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return "Present: 0, Longest streak: 0";
        }

        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0; // Reset streak on absence
            }
        }

        return "Present: " + presentCount + ", Longest streak: " + longestStreak;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 6: Class Attendance Tracker ===");

        // Sample 1
        int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println("Sample 1 Input: " + Arrays.toString(sample1));
        String result1 = attendanceSummary(sample1);
        System.out.println("Expected Output: Present: 6, Longest streak: 3");
        System.out.println("Actual Output:   " + result1);

        // Sample 2
        int[] sample2 = {0, 0, 0};
        System.out.println("\nSample 2 Input: " + Arrays.toString(sample2));
        String result2 = attendanceSummary(sample2);
        System.out.println("Expected Output: Present: 0, Longest streak: 0");
        System.out.println("Actual Output:   " + result2);

        // Additional Edge Cases
        // All present
        int[] allPresent = {1, 1, 1, 1, 1};
        System.out.println("\nEdge Case (All Present): " + Arrays.toString(allPresent));
        System.out.println("Output: " + attendanceSummary(allPresent));

        // Single day present
        int[] singlePresent = {1};
        System.out.println("\nEdge Case (Single 1): " + Arrays.toString(singlePresent));
        System.out.println("Output: " + attendanceSummary(singlePresent));

        // Single day absent
        int[] singleAbsent = {0};
        System.out.println("\nEdge Case (Single 0): " + Arrays.toString(singleAbsent));
        System.out.println("Output: " + attendanceSummary(singleAbsent));

        // Alternating attendance
        int[] alternating = {1, 0, 1, 0, 1, 0};
        System.out.println("\nEdge Case (Alternating): " + Arrays.toString(alternating));
        System.out.println("Output: " + attendanceSummary(alternating));
    }
}
