import java.util.Arrays;

/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 3: Even and Odd Numbers in a List
 * 
 * Task:
 * Given a list of integers, write a program to count how many numbers in the list are even
 * and how many are odd. Print the counts for both categories.
 * 
 * Example:
 * Sample Input: [3, 8, 12, 5, 7, 10]
 * Expected Output:
 * Even: 3
 * Odd: 3
 * 
 * Hint:
 * Iterate through each number in the list. Use modulo operator (%) to determine if a number is even or odd.
 */

public class Question3_EvenAndOddNumbersInAList {

    public static void countEvenAndOdd(int[] numbers) {
        if (numbers == null) {
            System.out.println("Even: 0\nOdd: 0");
            return;
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Even and Odd Numbers in a List ===");

        int[] sample = {3, 8, 12, 5, 7, 10};
        System.out.println("Sample Input: " + Arrays.toString(sample));
        System.out.println("Expected Output:\nEven: 3\nOdd: 3");
        System.out.println("Actual Output:");
        countEvenAndOdd(sample);
    }
}
