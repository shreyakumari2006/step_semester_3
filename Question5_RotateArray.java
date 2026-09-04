import java.util.Arrays;

/**
 * Question 5: Rotate Array (Problem 15 - Category C)
 * 
 * Scenario:
 * A playlist needs to be shifted so the last few songs move to the front of the queue,
 * rotating the whole list to the right by k positions.
 * 
 * Concepts covered:
 * Modulo arithmetic, array index shifting, rotating array elements, building new array.
 */
public class Question5_RotateArray {

    /**
     * Rotates the array nums to the right by k steps.
     * 
     * @param nums Input array of integers.
     * @param k    Number of steps to rotate.
     * @return The rotated array.
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;
        // Normalize k
        k = k % n;
        if (k < 0) {
            k += n;
        }

        if (k == 0) {
            return nums;
        }

        int[] result = new int[n];

        // Shift elements to their new position
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result[newIndex] = nums[i];
        }

        // Copy back to original array for in-place effect
        System.arraycopy(result, 0, nums, 0, n);

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("=== Question 5: Rotate Array ===");

        // Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("\nTest Case 1 Input: nums=" + Arrays.toString(nums1) + ", k=" + k1);
        rotateArray(nums1, k1);
        System.out.println("Output: " + Arrays.toString(nums1));

        // Test Case 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("\nTest Case 2 Input: nums=" + Arrays.toString(nums2) + ", k=" + k2);
        rotateArray(nums2, k2);
        System.out.println("Output: " + Arrays.toString(nums2));
    }
}
