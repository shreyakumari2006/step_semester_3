/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 7: Factorial Calculation
 * 
 * Task:
 * Write a program that reads a non-negative integer and calculates its factorial.
 * The factorial of a non-negative integer 'n', denoted by 'n!', is the product of all positive
 * integers less than or equal to 'n'. The factorial of 0 is defined as 1.
 * 
 * Example:
 * Sample Input:
 * 5
 * 0
 * 
 * Expected Output:
 * 120
 * 1
 * 
 * Hint:
 * Use a loop to multiply numbers from 1 up to the input number. Handle the special case for 0 factorial.
 */

public class Question7_FactorialCalculation {

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 7: Factorial Calculation ===");

        int[] sampleInputs = {5, 0};
        for (int n : sampleInputs) {
            System.out.println(calculateFactorial(n));
        }
    }
}
