import java.util.Arrays;

/**
 * Question 3: Contains Duplicate (Problem 13 - Category C)
 * 
 * Scenario:
 * Before finalizing an exam seating plan, the office must double-check that no roll number
 * was accidentally entered twice in the list by pairwise comparison.
 * 
 * Concepts covered:
 * Nested loops, pairwise comparison, boolean return logic, early exit on first match.
 */
public class Question3_ContainsDuplicate {

    /**
     * Checks if the array contains any duplicate values using nested loops.
     * 
     * @param nums Array of integers.
     * @return true if any value appears at least twice, false if every element is distinct.
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        // Using two nested loops, compare every element at i against element at j
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Found a duplicate
                }
            }
        }

        return false; // No duplicate found
    }

    public static void main(String[] args) {
        System.out.println("=== Question 3: Contains Duplicate ===");

        // Test Case 1: Contains duplicates
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + containsDuplicate(nums1));

        // Test Case 2: All distinct
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + containsDuplicate(nums2));
    }
}
