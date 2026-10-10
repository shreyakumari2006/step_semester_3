import java.util.Arrays;

/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 4: In-Place Array Reversal
 * 
 * Task:
 * Write a program that reverses the order of token numbers stored in a list. The reversal must be
 * done 'in-place', meaning you should modify the original list directly without creating a second list.
 * 
 * Example:
 * Sample Input: [11, 22, 33, 44]
 * Expected Output: [44, 33, 22, 11]
 * 
 * Hint:
 * Use two pointers, one starting from the beginning and one from the end of the array. Swap the
 * elements at these pointers and move them towards the center until they meet or cross.
 */

public class Question4_InPlaceArrayReversal {

    public static void reverseInPlace(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: In-Place Array Reversal ===");

        int[] sample = {11, 22, 33, 44};
        System.out.println("Sample Input: " + Arrays.toString(sample));

        reverseInPlace(sample);
        System.out.println("Expected Output: [44, 33, 22, 11]");
        System.out.println("Actual Output:   " + Arrays.toString(sample));

        // Additional odd-length test
        int[] oddSample = {1, 2, 3, 4, 5};
        System.out.println("\nOdd Length Input: " + Arrays.toString(oddSample));
        reverseInPlace(oddSample);
        System.out.println("Reversed Output:  " + Arrays.toString(oddSample));
    }
}
