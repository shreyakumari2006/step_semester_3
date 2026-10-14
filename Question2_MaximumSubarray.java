import java.util.Arrays;

/**
 * Question 2: Maximum Subarray (Problem 17)
 * 
 * Scenario:
 * A trader has a log of daily returns. To measure peak performance streak or highest cumulative returns,
 * the contiguous subarray with the largest sum is found using Kadane's algorithm in O(n) time.
 * 
 * Concepts covered:
 * Kadane's algorithm, max subarray, linear traversal, running sum tracking.
 */
public class Question2_MaximumSubarray {

    /**
     * Finds the contiguous subarray with the largest sum using Kadane's algorithm.
     * 
     * @param nums Input array of numbers (can contain negatives).
     * @return The maximum subarray sum.
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the subarray or start fresh
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println("=== Question 2: Maximum Subarray ===");

        // Test Case 1: Mixed values
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + maxSubArray(nums1));

        // Test Case 2: Single element
        int[] nums2 = {1};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + maxSubArray(nums2));

        // Test Case 3: All positive
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("\nTest Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + maxSubArray(nums3));
    }
}
