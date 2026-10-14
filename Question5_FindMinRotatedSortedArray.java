import java.util.Arrays;

/**
 * Question 5: Find Minimum in Rotated Sorted Array (Problem 20)
 * 
 * Scenario:
 * A system log order was originally sorted but rotated at an unknown pivot.
 * To find the minimum element efficiently in O(log n) time, modified binary search is applied.
 * 
 * Concepts covered:
 * Binary search, rotated sorted array, logarithmic time complexity O(log n).
 */
public class Question5_FindMinRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array in O(log n) time.
     * 
     * @param nums Rotated sorted array of unique elements.
     * @return The minimum element.
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("=== Question 5: Find Minimum in Rotated Sorted Array ===");

        // Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + findMin(nums1));

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + findMin(nums2));

        // Test Case 3: Fully sorted / rotated n times
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("\nTest Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + findMin(nums3));
    }
}
