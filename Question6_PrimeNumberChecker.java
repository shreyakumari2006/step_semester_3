/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 6: Prime Number Checker
 * 
 * Task:
 * Write a program that reads a number greater than 1 and determines whether it is a prime number.
 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * Print whether the number is prime or not.
 * 
 * Example:
 * Sample Input:
 * 29
 * 21
 * 
 * Expected Output:
 * 29 is prime
 * 21 is not prime
 * 
 * Hint:
 * To check for primality, iterate from 2 up to the square root of the number. If any number in this range
 * divides the input number evenly, it's not prime.
 */

public class Question6_PrimeNumberChecker {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void checkAndPrint(int n) {
        if (isPrime(n)) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 6: Prime Number Checker ===");

        int[] sampleInputs = {29, 21};
        for (int n : sampleInputs) {
            checkAndPrint(n);
        }
    }
}
