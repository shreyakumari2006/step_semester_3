import java.util.Arrays;

/**
 * Question 1: Product of Array Except Self (Problem 16)
 * 
 * Scenario:
 * Building report tools for components that audits the combined product of array items
 * for business metrics — calculating product excluding current item without dividing by zero.
 * 
 * Constraints:
 * - Must run in O(n) time and without using the division operation.
 * - Extra space complexity: O(1) (excluding output array).
 */
public class Question1_ProductOfArrayExceptSelf {

    /**
     * Calculates an array such that output[i] is the product of all elements of nums except nums[i].
     * 
     * @param nums Input integer array.
     * @return Output array with product of elements except self.
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int n = nums.length;
        int[] output = new int[n];

        // Pass 1: Calculate left/prefix products
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Pass 2: Multiply by right/suffix products on the fly
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println("=== Question 1: Product of Array Except Self ===");

        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] res1 = productExceptSelf(nums1);
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(res1));

        // Test Case 2 (with zeros and negative numbers)
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] res2 = productExceptSelf(nums2);
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(res2));
    }
}
