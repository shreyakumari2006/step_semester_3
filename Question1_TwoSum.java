import java.util.Arrays;

/**
 * Question 1: Two Sum (Problem 11 - Category C)
 * 
 * Scenario:
 * A shopkeeper wants to find two items from a list of prices that together add up to exactly
 * the customer's budget using nested loops to find the matching pair of indices.
 * 
 * Concepts covered:
 * Nested for loops, array indexing, early return on first match.
 */
public class Question1_TwoSum {

    /**
     * Finds indices of the two numbers in nums that add up to target.
     * 
     * @param nums   Array of integers.
     * @param target The target sum.
     * @return Array containing the two indices [i, j].
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        // Check every pair of different positions using nested loops
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0]; // If no pair matches
    }

    public static void main(String[] args) {
        System.out.println("=== Question 1: Two Sum ===");

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("\nTest Case 1 Input: nums=" + Arrays.toString(nums1) + ", target=" + target1);
        System.out.println("Output: " + Arrays.toString(result1));

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("\nTest Case 2 Input: nums=" + Arrays.toString(nums2) + ", target=" + target2);
        System.out.println("Output: " + Arrays.toString(result2));
    }
}
