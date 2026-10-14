/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 2: Word Reverser and Palindrome Checker
 * 
 * Task:
 * Create a program that reads a word, reverses it using a mutable text builder (like StringBuilder in Java),
 * and then prints the reversed word. Additionally, determine and print whether the original word reads
 * the same forwards and backwards (is a palindrome).
 * 
 * Example:
 * Sample Input:
 * level
 * java
 * 
 * Expected Output:
 * level - palindrome
 * avaj - not a palindrome
 * 
 * Hint:
 * Use a mutable string class to build the reversed word. Compare the original string with the reversed
 * string to check for palindrome property. Remember to consider case sensitivity if not specified otherwise.
 */

public class Question2_WordReverserAndPalindromeChecker {

    public static String checkWord(String word) {
        if (word == null) {
            return "";
        }

        // Use StringBuilder to reverse the word
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        return reversed + " - " + (isPalindrome ? "palindrome" : "not a palindrome");
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Word Reverser and Palindrome Checker ===");

        String[] testWords = {"level", "java"};

        for (String word : testWords) {
            System.out.println(checkWord(word));
        }
    }
}
