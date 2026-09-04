import java.util.*;

/**
 * Question 3: 3Sum (Problem 18)
 * 
 * Scenario:
 * Budgeting systems in financial services need to combine three invoices or voucher amounts
 * that sum exactly to zero without duplicate combinations.
 * 
 * Concepts covered:
 * Two-pointer technique, sorting, duplicate skipping, combination searching.
 */
public class Question3_ThreeSum {

    /**
     * Finds all unique triplets in the array which gives the sum of zero.
     * 
     * @param nums Input integer array.
     * @return List of all unique triplets summing to 0.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        // Sort the array to enable two-pointer approach and avoid duplicates
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // If the current number is greater than 0, triplet sum cannot be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for second and third elements
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Question 3: 3Sum ===");

        // Test Case 1: Multiple triplets
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("\nTest Case 1 Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + threeSum(nums1));

        // Test Case 2: No valid triplets
        int[] nums2 = {0, 1, 1};
        System.out.println("\nTest Case 2 Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSum(nums2));

        // Test Case 3: All zeros
        int[] nums3 = {0, 0, 0};
        System.out.println("\nTest Case 3 Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + threeSum(nums3));
    }
}
