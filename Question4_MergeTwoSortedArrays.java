import java.util.Arrays;

/**
 * Question 4: Merge Two Sorted Arrays (Problem 14 - Category C)
 * 
 * Scenario:
 * Two class sections each submit exam scores already sorted. The examination office needs one
 * combined sorted list without throwing both lists together and re-sorting everything from scratch.
 * 
 * Concepts covered:
 * Two-pointer technique for sorted arrays, while loop, conditional copying, leftover array appending.
 */
public class Question4_MergeTwoSortedArrays {

    /**
     * Merges two sorted integer arrays into one sorted array using two pointers.
     * 
     * @param arr1 First sorted array.
     * @param arr2 Second sorted array.
     * @return A new sorted array containing all elements from arr1 and arr2.
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return new int[0];
        }
        if (arr1 == null || arr1.length == 0) {
            return arr2 != null ? arr2.clone() : new int[0];
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1.clone();
        }

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result array

        // Compare elements from both arrays and copy smaller one
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1, if any
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2, if any
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Question 4: Merge Two Sorted Arrays ===");

        // Test Case 1
        int[] arr1_1 = {1, 3, 5};
        int[] arr2_1 = {2, 4, 6};
        int[] merged1 = mergeSortedArrays(arr1_1, arr2_1);
        System.out.println("\nTest Case 1 Input: arr1=" + Arrays.toString(arr1_1) + ", arr2=" + Arrays.toString(arr2_1));
        System.out.println("Output: " + Arrays.toString(merged1));

        // Test Case 2: One empty array
        int[] arr1_2 = {};
        int[] arr2_2 = {1, 2};
        int[] merged2 = mergeSortedArrays(arr1_2, arr2_2);
        System.out.println("\nTest Case 2 Input: arr1=" + Arrays.toString(arr1_2) + ", arr2=" + Arrays.toString(arr2_2));
        System.out.println("Output: " + Arrays.toString(merged2));
    }
}
