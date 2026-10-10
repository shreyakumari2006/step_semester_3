import java.util.Scanner;

/**
 * Category C: Data Structure Practice
 * Part A — Coding Problems
 * Problem 1: Vowel and Consonant Counter
 * 
 * Task:
 * Write a program that reads a single word and then counts and prints the total number of vowels
 * and consonants in that word. Assume the input word contains only alphabetic characters (case-insensitive).
 * 
 * Example:
 * Sample Input: Programming
 * Expected Output:
 * Vowels: 3
 * Consonants: 8
 * 
 * Hint:
 * Iterate through each character of the word. Use conditional statements to check if a character
 * is a vowel ('a', 'e', 'i', 'o', 'u' case-insensitive). All other alphabetic characters are consonants.
 */

public class Question1_VowelAndConsonantCounter {

    public static void countVowelsAndConsonants(String word) {
        if (word == null) {
            System.out.println("Vowels: 0\nConsonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            char rawCh = word.charAt(i);
            char ch = java.lang.Character.toLowerCase(rawCh);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Vowel and Consonant Counter ===");

        String sampleWord = "Programming";
        System.out.println("Sample Input: " + sampleWord);
        System.out.println("Expected Output:\nVowels: 3\nConsonants: 8");
        System.out.println("Actual Output:");
        countVowelsAndConsonants(sampleWord);
    }
}
