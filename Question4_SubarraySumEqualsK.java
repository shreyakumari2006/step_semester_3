import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question 4: Subarray Sum Equals K (Problem 19)
 * 
 * Scenario:
 * A meter reading sensor logs cumulative differences. To identify anomalies across continuous
 * time intervals, the number of continuous subarrays whose sum equals target value k is computed
 * in O(n) time using a prefix sum HashMap.
 * 
 * Concepts covered:
 * Prefix sum, HashMap for frequency tracking, continuous subarray sum counting.
 */
public class Question4_SubarraySumEqualsK {

    /**
     * Returns the total number of continuous subarrays whose sum equals k.
     * 
     * @param nums Input array of integers (can contain negatives).
     * @param k    Target sum.
     * @return Count of subarrays summing to k.
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int currentSum = 0;

        // Map to store prefixSum -> frequency
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // Base case: prefix sum of 0 occurs once before array starts
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) has been seen, add its frequency
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Update frequency of currentSum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Question 4: Subarray Sum Equals K ===");

        // Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("\nTest Case 1 Input: nums=" + Arrays.toString(nums1) + ", k=" + k1);
        System.out.println("Output: " + subarraySum(nums1, k1));

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("\nTest Case 2 Input: nums=" + Arrays.toString(nums2) + ", k=" + k2);
        System.out.println("Output: " + subarraySum(nums2, k2));

        // Test Case 3: With negative numbers
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("\nTest Case 3 Input: nums=" + Arrays.toString(nums3) + ", k=" + k3);
        System.out.println("Output: " + subarraySum(nums3, k3));
    }
}
