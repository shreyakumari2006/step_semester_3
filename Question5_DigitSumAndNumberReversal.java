/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 5: Digit Sum and Number Reversal
 * 
 * Task:
 * Write a program that reads a positive integer and performs two operations: it calculates and prints
 * the sum of its digits, and it prints the number with its digits reversed.
 * 
 * Example:
 * Sample Input: 4721
 * Expected Output:
 * Sum of digits: 14
 * Reverse: 1274
 * 
 * Hint:
 * To extract digits, repeatedly use the modulo operator (%) by 10 to get the last digit and integer
 * division (/) by 10 to remove the last digit. Build the reversed number by multiplying the current
 * reversed number by 10 and adding the extracted digit.
 */

public class Question5_DigitSumAndNumberReversal {

    public static void processNumber(int number) {
        int sumOfDigits = 0;
        int reversedNumber = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sumOfDigits += digit;
            reversedNumber = (reversedNumber * 10) + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sumOfDigits);
        System.out.println("Reverse: " + reversedNumber);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Digit Sum and Number Reversal ===");

        int sample = 4721;
        System.out.println("Sample Input: " + sample);
        System.out.println("Expected Output:\nSum of digits: 14\nReverse: 1274");
        System.out.println("Actual Output:");
        processNumber(sample);
    }
}
